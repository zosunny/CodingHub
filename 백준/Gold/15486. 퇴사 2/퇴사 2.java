import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][2];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];
        for(int i=1; i<N+2; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i > N) continue;
            int next = i + arr[i][0];
            if(next > N+1) continue;
            dp[next] = Math.max(dp[next], dp[i] + arr[i][1]);
        }
        System.out.println(dp[N+1]);
    }
}
