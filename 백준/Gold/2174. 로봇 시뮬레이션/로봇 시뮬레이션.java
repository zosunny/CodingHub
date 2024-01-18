import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int A;
	static int B;
	static int N;
	static int M;
	static int[][] map;
	static Point[] robot;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int flag;

	static class Point{
		int x;
		int y;
		int d;
		Point(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	// 주어진 명령을 실행
	public static void bfs(int r, char num, int cnt) {
		for(int i=0; i<cnt; i++) {
			Point p = robot[r];
			int nx = p.x;
			int ny = p.y;
			int nd = p.d;
			// 명령이 L인 경우
			if(num == 'L') {
				nd = (p.d + 3) % 4;
				// 로봇 정보 변경
				robot[r] = new Point(nx, ny, nd);
				continue;
			} else if(num == 'R') {
				nd = (p.d + 1) % 4;
				// 로봇 정보 변경
				robot[r] = new Point(nx, ny, nd);
				continue;
			} else {
				nx = p.x + dx[nd];
				ny = p.y + dy[nd];
			}
			// 범위를 벗어나는 경우
			if(nx<0 || ny<0 || nx>=B || ny>=A) {
				flag = 1;
				System.out.println("Robot " + r + " crashes into the wall");
				return;
			}
			// 다른 로봇에 충돌하는 경우
			if(map[nx][ny] != 0 && map[nx][ny] != r) {
				flag = 2;
				System.out.println("Robot " + r + " crashes into robot " + map[nx][ny]);
				return;
			}
			// 로봇을 map에서 이동시킴
			map[p.x][p.y] = 0;
			map[nx][ny] = r;
			// 로봇 정보 변경
			robot[r] = new Point(nx, ny, nd);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());	// 열
		B = Integer.parseInt(st.nextToken());	// 행
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 로봇 개수
		M = Integer.parseInt(st.nextToken());	// 명령 개수
		
		// 로봇 초기 위치 정보 저장
		map = new int[B][A];
		robot = new Point[N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// x좌표 (열)
			int y = Integer.parseInt(st.nextToken());	// y좌표 (행)
			char d = st.nextToken().charAt(0);			// 방향
			map[B-y][x-1] = i+1;		// 로봇 번호를 map에 저장
			int start = 0;
			if(d == 'N') start = 0;
			else if(d == 'E') start = 1;
			else if(d == 'S') start = 2;
			else start = 3;
			robot[i+1] = new Point(B-y, x-1, start);			// 로봇 정보를 저장
		}

		// 명령을 하나씩 실행
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken());	// 로봇번호
			char num = st.nextToken().charAt(0);			// 명령종류
			int cnt = Integer.parseInt(st.nextToken());		// 반복횟수
			bfs(robot, num, cnt);
			if(flag != 0) return;
		}
		if(flag == 0) System.out.println("OK");
	}
}