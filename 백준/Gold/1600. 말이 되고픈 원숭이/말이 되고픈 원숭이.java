import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int K;
	static int W, H;
	static int cnt;
	
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};
	
	static class Point{
		int x, y, k;
		Point(int x, int y, int k){
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize --> 0) {
				Point p = q.poll();
				
				// 도착점에 도착하면 동작수 출력
				if(p.x == H-1 && p.y == W-1) return cnt;
				
				// 말의 이동
				if(p.k < K) {
					for(int i=4; i<12; i++) {
						int nx = p.x + dx[i];
						int ny = p.y + dy[i];
						int nk = p.k + 1;
						if(nx<0 || ny<0 || nx>=H || ny>=W || visited[nx][ny][nk] || arr[nx][ny]==1) continue;
						q.add(new Point(nx, ny, nk));
						visited[nx][ny][nk] = true;
					}
				}
				
				// 원숭이의 이동
				for(int i=0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(nx<0 || ny<0 || nx>=H || ny>=W || visited[nx][ny][p.k] || arr[nx][ny]==1) continue;
					q.add(new Point(nx, ny, p.k));
					visited[nx][ny][p.k] = true;
				}
			}
			cnt++;
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[H][W][K+1];
		System.out.println(bfs());
	}
}
