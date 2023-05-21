import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int D, W, K;
	static int minAns;
	
	static int[][] arr;
	static int[] input;
	
	public static boolean isPass(int[] input) {
		// 모든 각각의 열에 대해 성능기준 통과하는 지 검사
		for(int j=0; j<W; j++) {
			int cnt = 0;
			for(int i=0; i<D-1; i++) {
				int now = input[i];
				int next = input[i+1];
				// 해당 행이 원본 값을 가지면
				if(now == -1) {
					now = arr[i][j];
				}
				if(next == -1) {
					next = arr[i+1][j];
				}
				// 한 열중에서 앞,뒤 행의 값이 같으면
				if(now == next) {
					cnt++;
					// 합격 기준을 넘기면 바로 통과, 다음 열 검사
					if(cnt>=K-1) {
						break;
					}
				}else {
					cnt = 0;
				}
			}
			// 합격 기준 못넘기면 성능검사 불통임
			if(cnt<K-1) {
				return false;
			}
		}
		// 모든 열 다 잘 통과 했음 통과!
		return true;
	}
	
	// 모든 행에 약품 A넣는거(0), B넣는거(1), 안넣는거(-1) 완탐
	public static void subset(int cnt, int[] select) {
		if(cnt == D) {
			// 각 행에 대한 정보를 담을 1차원 배열
			input = new int[D];
			int tmp = 0;
			for(int i=0; i<D; i++) {
				input[i] = select[i];
				// 약품 투입 횟수
				if(select[i]!=-1) {
					tmp++;
				}
			}
			// 성능검사 해보자
			// 성능검사 통과했을 때만 약품 투입 횟수 최솟값 갱신
			if(isPass(input)) {
				minAns = Math.min(minAns, tmp);
			}
			return;
		}
		select[cnt] = 0;
		subset(cnt+1, select);
		select[cnt] = 1;
		subset(cnt+1, select);
		select[cnt] = -1;
		subset(cnt+1, select);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			
			minAns = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());	// 세로
			W = Integer.parseInt(st.nextToken());	// 가로
			K = Integer.parseInt(st.nextToken());	// 합격기준
			
			// 막 정보 입력
			arr = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 처음 검사할 모든 행에 대한 정보 -> 원본이니까 -1로 채움
			input = new int[D];
			Arrays.fill(input, -1);
			
			// 처음에 성능검사 통과하는 지 확인
			if(isPass(input)) {
				minAns = 0;
			// 모든 행에 약품 넣어보며 통과가능한 최소 투입 횟수 탐색
			}else {
				int[] select = new int[D];
				subset(0, select);
			}
			sb.append("#" + (t+1) + " " + minAns + "\n");
		}
		System.out.println(sb.toString());
	}
}