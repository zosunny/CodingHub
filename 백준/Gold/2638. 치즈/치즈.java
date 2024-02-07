import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cheeses;
	static int answer;
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
				// 바로 옆에 치즈가 있으면
				if(arr[nx][ny] == 1) {
					check[nx][ny] += 1;
				}else {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheeses++;
			}
		}
		
		while(cheeses>0) {
			check = new int[N][M];
			visited = new boolean[N][M];
			bfs(0, 0);
			// 녹는 치즈 삭제
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(check[i][j] >= 2) {
						arr[i][j] = 0;
						cheeses--;
					}
				}
			}
			// 걸리는 시간
			answer++;
		}
		System.out.println(answer);
	}
}