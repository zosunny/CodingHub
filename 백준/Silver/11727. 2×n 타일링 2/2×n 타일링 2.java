import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 10007;

        long[] dp = new long[n+1];
        if(n == 1) System.out.println(1);
        else{
            dp[1] = 1;
            dp[2] = 3;
            for(int i=3; i<n+1; i++){
                dp[i] = (dp[i-1] + dp[i-2] * 2) % MOD;
            }
            System.out.println(dp[n]);
        }
    }
}