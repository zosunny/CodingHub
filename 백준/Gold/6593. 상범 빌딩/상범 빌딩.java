import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int L, R, C;
	static Point start, end;
	static int time;
	static int flag;
	
	static int[] dx = {0, 0, 1, -1, 0, 0};	// 동, 서, 남, 북, 상, 하
	static int[] dy = {1, -1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static boolean[][][] visited;
	static char[][][] arr;
	
	static class Point{
		int z, x, y;
		Point(int z, int x, int y){
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(Point s) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(s.z, s.x, s.y));
		visited[s.z][s.x][s.y] = true;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize --> 0) {
				Point p = q.poll();
				for(int i=0; i<6; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					int nz = p.z + dz[i];
					// 범위 밖이거나 막혀있는 칸
					if(nx<0 || ny<0 || nz<0 || nx>=R || ny>=C || nz>=L || arr[nz][nx][ny]=='#') continue;
					// 도착점에 도착했으면
					if(arr[nz][nx][ny]=='E') {
						flag = 1;
						return;
					}
					// 범위 안이고 방문 아직 안했으면
					if(!visited[nz][nx][ny] && arr[nz][nx][ny]=='.') {
						q.add(new Point(nz, nx, ny));
						visited[nz][nx][ny] = true;
					}
				}
			}
			time++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());	// 층
			R = Integer.parseInt(st.nextToken());	// 행
			C = Integer.parseInt(st.nextToken());	// 열
			
			// 모두 0을 적으면 끝
			if(L==0 && R==0 && C==0) break; 
			
			// 빌딩 정보 입력 받기
			arr = new char[L][R][C];
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String str = br.readLine();
					for(int k=0; k<C; k++) {
						arr[i][j][k] = str.charAt(k);
						// 시작좌표
						if(arr[i][j][k] == 'S') start = new Point(i, j, k);
						// 끝좌표
						if(arr[i][j][k] == 'E') end = new Point(i, j, k);
					}
				}
				br.readLine();
			}
			
			visited = new boolean[L][R][C];
			flag = 0;
			time = 1;
			
			bfs(start);
			
			if(flag == 1) {
				sb.append("Escaped in " + time + " minute(s).\n");
			}else {
				sb.append("Trapped!\n");
			}
		}
		System.out.println(sb.toString());
	}
}