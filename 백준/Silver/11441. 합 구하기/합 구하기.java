import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[e] - dp[s-1]).append("\n");
        }
        System.out.println(sb);
    }
}