import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 4;
        dp[7] = 5;
        for(int i=8; i<100; i++){
            dp[i] = dp[i-5] + dp[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n-1] + "\n");
        }

        System.out.println(sb.toString());
    }
}