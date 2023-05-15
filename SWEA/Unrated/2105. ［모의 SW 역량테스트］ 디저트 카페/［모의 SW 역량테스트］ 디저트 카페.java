import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N;
	static int startX;
	static int startY;
	static int maxCnt;
	
	static int[][] arr;
	static boolean[] visited;
	static int[] dx = {1, -1, -1, 1};
	static int[] dy = {-1, -1, 1, 1};
	
	public static void dfs(int x, int y, int cnt, int start, boolean[] visited) {
		// 먹은 디저트 방문처리
		visited[arr[x][y]] = true;
		
		// 처음 방문하면 초기 좌표 기억
		if(cnt==0) {
			startX = x;
			startY = y;
		}
		// 디저트 한 방향으로만 가야함
		for(int i=start; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 벗어나는 경우 제외
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			// 처음 자리로 돌아오면 카운트
			if(nx==startX && ny==startY && cnt>1) {
				maxCnt = Math.max(maxCnt, cnt+1);
				return;
			}
			// 같은 디저트 먹었었으면 제외 -> 이전에 방문했던 곳도 여기서 처리됨
			if(visited[arr[nx][ny]]) continue;
			// 그외 재귀
			// 배열은 원본 손실 방지위해 깊은 복사해서 넘겨야 됨
			boolean[] copyVisit = deepcopy(visited);
			dfs(nx, ny, cnt+1, i, copyVisit);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			maxCnt = -1;
			
			N = Integer.parseInt(br.readLine());
			// 디저트 종류 배열
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 맨 처음 카페부터 탐색 시작
			for(int i=0; i<N*N; i++) {
				visited = new boolean[101];
				dfs(i/N, i%N, 0, 0, visited);
			}
			sb.append("#" + (t+1) + " " + maxCnt +"\n");
		}
		System.out.println(sb);
	}
	
	// 방문처리 배열 깊은 복사
	public static boolean[] deepcopy(boolean[] arr) {
		boolean[] copy = new boolean[arr.length];
		for(int i=0; i<arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}
}