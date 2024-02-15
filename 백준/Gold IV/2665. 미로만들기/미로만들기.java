import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static char[][] arr;
	static int[][] dis;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Point implements Comparable<Point>{
		int x, y, wall;
		Point(int x, int y, int wall){
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
		@Override
		public int compareTo(Point o) {
			return this.wall - o.wall;
		}
	}
	
	public static void dijk(int x, int y) {
		boolean[][] visited = new boolean[n][n];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(x, y, 0));
		dis[x][y] = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(visited[p.x][p.y]) continue;
			visited[p.x][p.y] = true;
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(arr[nx][ny] == '0') dis[nx][ny] = Math.min(dis[nx][ny], dis[p.x][p.y] + 1);
				else dis[nx][ny] = Math.min(dis[nx][ny], dis[p.x][p.y]);
				pq.add(new Point(nx, ny, dis[nx][ny]));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		dis = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}
		dijk(0, 0);
		System.out.println(dis[n-1][n-1]);
	}
}