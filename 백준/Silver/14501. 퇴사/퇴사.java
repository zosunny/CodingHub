import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());       // 날짜
            arr[i][1] = Integer.parseInt(st.nextToken());       // 금액
        }

        int[] dp = new int[n+1];
        dp[n] = 0;

        int ans = 0;
        for(int i=n-1; i>=0; i--){
            // 일을 할 수 있는지 확인
            if(i + arr[i][0] > n) continue;
            // 그 뒤 날짜 다 확인해서 최댓값 갱신
            for(int j=i + arr[i][0]; j<n+1; j++){
                dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
}