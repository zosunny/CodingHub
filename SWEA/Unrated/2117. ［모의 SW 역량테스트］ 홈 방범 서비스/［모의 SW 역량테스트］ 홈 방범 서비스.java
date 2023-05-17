import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N;
	static int M;
	static int K;
	static int cost;
	static int maxCnt;
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void clac(int cnt, int k) {
		// 각 운영 영역의 크기별로 계산
		// 현재 k에서 보안회사의 이익
		cost = (M * cnt) - ((k * k) + (k-1)*(k-1));
		// 홈방범 서비스를 제공받는 집들의 수의 최댓값(단, 손해보면 안됨)
		if(cost >= 0) {
			maxCnt = Math.max(maxCnt, cnt);
		}
	}
	
	public static void bfs(int x, int y, int k) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		int cnt = 0;
		visited[x][y] = true;
		if(arr[x][y]==1) cnt++;
		clac(cnt, 1);
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-->0) {
				Point p = q.poll();
				for(int i=0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					// 영역 넘어가는 건 상관없지만 조건은 걸어줘야 함, 방문했던 곳은 제외
					if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
					// 집들의 수 계산
					if(!visited[nx][ny] && arr[nx][ny]==1) cnt++;
					// 그외
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
			k++;
			// 최대 영역 크기까지만 계산 가능
			if(k > K) return;
			
			clac(cnt, k);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 도시의 크기
			M = Integer.parseInt(st.nextToken());	// 하나의 집이 지불할 수 있는 비용 M
			// 최대 운영 영역의 크기로 만드는 거리
			K = N+1;
			
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 매 테케별 초기화
			maxCnt = Integer.MIN_VALUE;
			
			for(int i=0; i<N*N; i++) {
				visited = new boolean[N][N];
				bfs(i/N, i%N, 1);
			}
			sb.append("#" + (t+1) + " " + maxCnt + "\n");
		}
		System.out.println(sb);
	}
}