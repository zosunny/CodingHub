import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, answer;
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static int dfs(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		dp[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || nx>=n || ny>=n || arr[nx][ny]<=arr[x][y]) continue;
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			dfs(nx, ny);
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	}
}