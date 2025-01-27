import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0) break;
                // 오른쪽으로 이동하는 경우
                if(j + arr[i][j] < n) dp[i][j + arr[i][j]] += dp[i][j];
                // 아래로 이동하는 경우
                if(i + arr[i][j] < n) dp[i + arr[i][j]][j] += dp[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}