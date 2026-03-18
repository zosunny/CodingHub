import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 10007;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1], 1);

        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        int ans = 0;
        for(int x : dp[N]) ans += x;

        System.out.println(ans % MOD);
    }
}
