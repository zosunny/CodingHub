import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;	// 가로
	static int M;	// 세로
	static int H;	// 높이
	static int num;
	static int answer = -1;
	static int[][][] arr;
	static Queue<Point> ripen;
	static boolean[][][] visited;
	static int[] dx = {0, 0, 1, -1, 0, 0};	// 상, 하, 좌, 우, 앞, 뒤
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	
	static class Point{
		int x;
		int y;
		int z;
		Point(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	// 토마토 익히는 함수
	public static void bfs() {
		// 모든 익은 토마토에서 6방향으로 동시에 1번(1일)씩 나아가야함
		while(!ripen.isEmpty()) {
			int qSize = ripen.size();
			while(qSize --> 0) {
				Point p = ripen.poll();
				for(int i=0; i<6; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					int nz = p.z + dz[i];
					// 범위 밖이거나 이전에 방문한 경우
					if(nx<0 || ny<0 || nz<0 || nx>=N || ny>=M || nz>=H || visited[nx][ny][nz]) continue;
					// 안익은 토마토를 만난 경우
					if(arr[nx][ny][nz] == 0) {
						num--;
						arr[nx][ny][nz] = 1;
						ripen.add(new Point(nx, ny, nz));
					}
					visited[nx][ny][nz] = true;
				}
			}
			answer++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// M행 N열로 이루어진 한 판을 H층으로 입력
		arr = new int[N][M][H];
		ripen = new LinkedList<>();
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					arr[j][k][i] = Integer.parseInt(st.nextToken());
					// 익은 토마토의 좌표 저장
					if(arr[j][k][i] == 1) ripen.add(new Point(j, k, i));
					// 안익은 토마토의 개수 저장
					if(arr[j][k][i] == 0) num++;
				}
			}
		}
		
		// 모든 토마토가 익어있는 상태면 0 출력
		if(num == 0) System.out.println(0);
		else {
			visited = new boolean[N][M][H];
			bfs();
			// 토마토가 모두 익지 못했으면
			if(num != 0) System.out.println(-1);
			else System.out.println(answer);
		}
	}
}