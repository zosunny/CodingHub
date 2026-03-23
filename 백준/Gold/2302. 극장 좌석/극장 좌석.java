import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[M];
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int ans = 1;
        int s = 1;
        for(int i=0; i<M; i++){
            int e = arr[i];
            int tmp = e - s;
            ans *= dp[tmp];
            s = e + 1;
        }
        ans *= dp[N+1-s];

        System.out.println(ans);
    }
}