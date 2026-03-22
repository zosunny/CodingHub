import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int MOD = 9901;

        int[][] dp = new int[N][3];
        Arrays.fill(dp[0], 1);

        for(int i=1; i<N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        System.out.println((dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % MOD);
    }
}