import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N, M, K;		// 셀의 개수, 격리 시간, 미생물 군집의 개수
	static int ans;
	
	static ArrayList<Micro> micro;
	static int[] dx = {-1, 0, 1, 0};	// 위, 오른, 아래, 왼
	static int[] dy = {0, 1, 0, -1};
	
	static class Micro implements Comparable<Micro>{
		int x, y, num, dir;
		Micro(){}
		Micro(int x, int y, int num, int dir){
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
		// 미생물을 x축, y축, 미생물의 수를 순서대로 내림차순 정렬
		@Override
		public int compareTo(Micro o) {
			int tmp = o.x - this.x;
			if(tmp == 0) {
				tmp = o.y - this.y;
				if(tmp == 0) {
					tmp = o.num - this.num;
				}
			}
			return tmp;
		}
	}
	
	public static void calc() {
		for(int i=0; i<micro.size(); i++) {
			Micro p = micro.get(i);
			ans += p.num;
		}
	}
	
	public static void move() {
		// 한번 씩 이동 시키고, 약품 칸 처리
		for(int i=0; i<micro.size(); i++) {
			Micro m = micro.get(i);
			int nx = m.x + dx[m.dir];
			int ny = m.y + dy[m.dir];
			// 약품 칸이면 미생물 수 1/2, 방향 반대
			if(nx<1 || ny<1 || nx>=N-1 || ny>=N-1) {
				m.num /= 2;
				m.dir = (m.dir + 2) % 4;
				if(m.num <= 0) {
					micro.remove(i);
					i -= 1;
				}
			}
			m.x = nx;
			m.y = ny;
		}
		
		// 이동시킨 상태에서 정렬 -> 같은 칸끼리 모임
		Collections.sort(micro);
		
		// 같은 칸이면 더 큰 군집(앞 군집)으로 합쳐
		for(int i=0; i<micro.size()-1; i++) {
			Micro now = micro.get(i);
			Micro next = micro.get(i+1);
			
			// 같은 칸에 있는 군집이면
			if(now.x==next.x && now.y==next.y) {
				now.num += next.num;
				// 없애고
				micro.remove(i+1);
				i -= 1;
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			
			ans = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 미생물 군집 K개 정보 입력
			micro = new ArrayList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				if(dir == 1) dir = 0;
				else if(dir == 2) dir = 2;
				else if(dir == 3) dir = 3;
				else dir = 1;
				micro.add(new Micro(x, y, num, dir));
			}
			
			// M시간 동안 미생물 이동
			for(int m=0; m<M; m++) {
				move();
			}
				
			// 남아 있는 미생물 수는?
			calc();
			
			sb.append("#" + (t+1) + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}