import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];

        // 맨 윗줄 오른쪽으로 누적합
        dp[0][0] = arr[0][0];
        for(int j=1; j<m; j++){
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }

        // 위에서부터 내려오면서 좌우 비교
        for(int i=1; i<n; i++){
            // 내려오기
            for(int j=0; j<m; j++){
                dp[i][j] = dp[i-1][j] + arr[i][j];
            }
            // 오른쪽으로
            int[] left = new int[m];
            left[0] = dp[i][0];
            for(int j=1; j<m; j++){
                left[j] = Math.max(dp[i][j], left[j-1] + arr[i][j]);
            }
            // 왼쪽으로
            int[] right = new int[m];
            right[m-1] = dp[i][m-1];
            for(int j=m-2; j>=0; j--){
                right[j] = Math.max(dp[i][j], right[j+1] + arr[i][j]);
            }
            // 오/왼 비교
            for(int j=0; j<m; j++){
                dp[i][j] = Math.max(right[j], left[j]);
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}