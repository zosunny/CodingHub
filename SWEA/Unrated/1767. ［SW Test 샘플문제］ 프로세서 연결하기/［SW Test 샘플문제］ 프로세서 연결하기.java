import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	static int N;
	static int cSize;
	static int minLen;
	static int maxCoreCnt;

	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Point> cores;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static int isConnect(int x, int y, int d) {
		int len = 0;
		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 끝까지 연결이 되었으면
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				return len;
			// 코어가 있거나 전선이 있으면
			if (arr[nx][ny] == 1 || visited[nx][ny])
				return -1;
			// 그냥 이동
			x = nx;
			y = ny;
			len++;
		}
	}

	public static void dfs(int cnt, int ConnectCnt, int totalLen) {
		// 끝까지 프로세서들 다 연결했으면 최단길이 찾아
		if (cnt == cSize) {
			// 코어수가 너무 작으면
			if (maxCoreCnt > ConnectCnt) {
				return;
			}
			// 더 많은 코어를 연결했으면
			else if (maxCoreCnt < ConnectCnt) {
				maxCoreCnt = ConnectCnt;
				// 이 코어의 길이로 갱신
				minLen = totalLen;
				// 연결된 코어의 개수가 같으면
			} else {
				// 그때의 전선 최단길이 갱신
				minLen = Math.min(minLen, totalLen);
			}
			return;
		}
		// 순서대로 코어들 연결 시작

		Point now = cores.get(cnt);

		for (int d = 0; d < 4; d++) {
			// 코어가 해당 직선으로 연결 가능한지 확인
			int len = isConnect(now.x, now.y, d);

			if (len != -1) {
				// 전선 연결..
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				for (int i = 0; i < len; i++) {
					visited[nx][ny] = true;
					nx = nx + dx[d];
					ny = ny + dy[d];
				}
				dfs(cnt + 1, ConnectCnt + 1, totalLen + len);
				// 연결 해제..
				nx = now.x + dx[d];
				ny = now.y + dy[d];
				for (int i = 0; i < len; i++) {
					visited[nx][ny] = false;
					nx = nx + dx[d];
					ny = ny + dy[d];
				}
			} else {
				dfs(cnt + 1, ConnectCnt, totalLen);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			minLen = Integer.MAX_VALUE;
			maxCoreCnt = Integer.MIN_VALUE;

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			cores = new ArrayList<>();
			int def = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						// 가장자리에 있는 코어 -> 이미 연결된 코어
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							def++;
						// 가장자리 아닌 것들만 계산해볼거야
						else
							cores.add(new Point(i, j));
					}
				}
			}
			cSize = cores.size();
			visited = new boolean[N][N];
			dfs(0, def, 0);

			sb.append("#" + (t + 1) + " " + minLen + "\n");
		}
		System.out.println(sb.toString());
	}
}