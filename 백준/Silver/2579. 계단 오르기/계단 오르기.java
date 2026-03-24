import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+2];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n+2][2];
        Arrays.fill(dp[1], arr[1]);
        dp[2][0] = arr[2];
        dp[2][1] = arr[1] + arr[2];

        for(int i=3; i<n+1; i++){
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + arr[i];
            dp[i][1] = dp[i-1][0] + arr[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}