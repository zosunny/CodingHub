import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int len;
	static int K;
	static int cnt;
	static int answer = 1;
	static Belt[] belt;
	
	static class Belt{
		int num;
		boolean robot;
		Belt(int num, boolean robot){
			this.num = num;
			this.robot = robot;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		len = 2 * N;
		
		// 컨베이어벨트 1차원 배열에 저장
		belt = new Belt[len];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<len; i++) {
			belt[i] = new Belt(Integer.parseInt(st.nextToken()), false);
		}
		
		// 컨베이어벨트 돌리기
		while(true) {
			// 맨 뒤칸 저장해두고, 벨트 뒤에서부터 한칸씩 앞으로 이동
			Belt tmp = belt[len-1];
			for(int i=len-2; i>=0; i--) {
				// 내리는 위치에 로봇이 있으면 내리기
				if(i==N-1 && belt[i].robot) belt[i].robot = false;
				belt[i+1] = belt[i];
			}
			belt[0] = tmp;

			// 내리는 위치에 로봇이 있으면 내리기
			if(belt[N-1].robot) belt[N-1].robot = false;
			
			// 이때, 로봇이 앞칸으로 이동할 수 있으면 이동 (앞칸에 로봇이 없고, 내구도가 0이상)
			for(int i=N-2; i>=0; i--) {
				if(belt[i].robot && !belt[i+1].robot && belt[i+1].num>0) {
					belt[i].robot = false;
					belt[i+1].robot = true;
					belt[i+1].num--;
					if(belt[i+1].num == 0) {
						cnt++;
						// 내구도 0이 K개 이상이면 종료
						if(cnt >= K) {
							System.out.println(answer);
							return;
						}
					}
				}
			}
			
			// 올리는위치의 내구도가 0 이상이면 로봇을 올리고 내구도 감소
			if(belt[0].num > 0) {
				belt[0].robot = true;
				belt[0].num--;
				if(belt[0].num == 0) {
					cnt++;
					// 내구도 0이 K개 이상이면 종료
					if(cnt >= K) {
						System.out.println(answer);
						return;
					}
				}
			}
			answer++;
		}
	}
}