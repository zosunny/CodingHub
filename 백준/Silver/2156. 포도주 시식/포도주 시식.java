import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(arr[1]);
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        int ans = dp[2];
        for(int i=3; i<n+1; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}