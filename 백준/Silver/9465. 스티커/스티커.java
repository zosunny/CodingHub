import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(n == 1) {
                sb.append(Math.max(arr[0][0], arr[1][0])).append("\n");
                continue;
            }
            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];
            for(int i=2; i<n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }
            sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
        }
        System.out.println(sb.toString());
    }
}