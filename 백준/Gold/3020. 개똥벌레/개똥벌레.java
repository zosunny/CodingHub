import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] down = new int[h+1];
        int[] top = new int[h+1];

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());    // 석순
            if(i % 2 == 0) down[x]++;                   // 종유석
            else top[(h+1) - x]++;
        }

        // 석순 누적합
        for(int i=h-1; i>0; i--){
            down[i] += down[i+1];
        }

        // 종유석 누적합
        for(int i=1; i<h+1; i++){
            top[i] += top[i-1];
        }

        int[] dp = new int[h+1];
        int minX = Integer.MAX_VALUE;
        for(int i=1; i<h+1; i++){
            dp[i] = down[i] + top[i];
            minX = Math.min(minX, dp[i]);
        }
        int ans = 0;
        for(int i=1; i<h+1; i++){
            if(dp[i] == minX) ans++;
        }

        System.out.println(minX + " " + ans);
    }
}
