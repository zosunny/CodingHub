import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int flag;
	static int ans;
	
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void down() {
		// 각 열의 행을 탐색하다가 뿌요가 있으면 아래로 밀어
		for(int j=0; j<6; j++) {
			while(true) {
				// 해당 줄에 뿌요 있는 지 확인
				int cflag = 0;
				for(int i=10; i>=0; i--) {
					if(arr[i][j]!='.' && arr[i+1][j]=='.') {
						arr[i+1][j] = arr[i][j];
						arr[i][j] = '.';
						cflag++;
						if(i==0) {
							// i가 0일때, 맨 위도 '.'으로 만들어 주기
							arr[0][j] = '.';
						}
					}
				}
				// 맨 아래까지 다 내려왔으면 다음 열 탐색
				if(cflag==0) break;
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> puyo = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		puyo.add(new Point(x, y));
		// 원래 뿌요 저장
		char now = arr[x][y];
		// 연결된 같은 색 뿌요 개수
		int cnt  = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0 || ny<0 || nx>=12 || ny>=6 || visited[nx][ny] || arr[nx][ny]=='.') continue;
				// 다음 뿌요가 같은 색이면
				if(arr[nx][ny]==now) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
					puyo.add(new Point(nx, ny));
					cnt++;
				}
			}
		}
		// 같은 색 뿌요가 4개이상 연결되어있으면
		if(cnt>=3) {
			// '.'으로 만들어주기
			while(!puyo.isEmpty()) {
				Point py = puyo.poll();
				arr[py.x][py.y] = '.';
			}
			// 사라질 뿌요있음 표시
			flag = 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[12][6];
		for(int i=0; i<12; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		while(true) {
			
			flag = 0;
			visited = new boolean[12][6];
			
			// 한번 쫙 돌면서 없앨거 없애고
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(arr[i][j]!='.' && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			// 더 이상 같은 색 뿌요가 4개 이상 연결되어있지 않으면 끝
			if(flag == 0) {
				break;
			}
			// 아래로 밀기
			down();
			// 연쇄 처리
			ans++;

		}
		System.out.println(ans);
	}
}