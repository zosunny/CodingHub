import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[t+1];
        for(int i=1; i<t+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t+1][w+1];
        for(int i=1; i<t+1; i++){
            for(int j=0; j<w+1; j++){
                dp[i][j] = dp[i-1][j];
                if(j > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                int idx = j % 2 == 0 ? 1 : 2;
                if(idx == arr[i]) dp[i][j]++;
            }
        }
        int ans = 0;
        for(int i=0; i<w+1; i++){
            ans = Math.max(ans, dp[t][i]);
        }
        System.out.println(ans);
    }
}