import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1000000000;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<10; j++){
                if(j == 0) dp[i][j] = dp[i-1][1] % MOD;
                else if(j == 9) dp[i][j] = dp[i-1][8] % MOD;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }
        long ans = 0;
        for(long x : dp[n]) ans = (ans + x) % MOD;
        System.out.println(ans);
    }
}