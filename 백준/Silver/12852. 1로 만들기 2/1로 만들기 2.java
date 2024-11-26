import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Point{
        int cnt;
        int idx;
        Point(int cnt, int idx){
            this.cnt = cnt;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] dp = new Point[n+1];
        // 초기화
        for(int i=0; i<n+1; i++){
            dp[i] = new Point(Integer.MAX_VALUE, 0);
        }
        dp[1] = new Point(0, 0);

        for(int i=2; i<n+1; i++){
            // 1. 나누기 3
            if(i % 3 == 0) {
                if(dp[i].cnt > dp[i / 3].cnt+1){
                    dp[i] = new Point(dp[i / 3].cnt+1, i / 3);
                }
            }
            // 2. 나누기 2
            if(i % 2 == 0) {
                if(dp[i].cnt > dp[i / 2].cnt+1){
                    dp[i] = new Point(dp[i / 2].cnt+1, i / 2);
                }
            }
            // 3. 빼기 1
            if(dp[i].cnt > dp[i - 1].cnt+1){
                dp[i] = new Point(dp[i - 1].cnt+1, i - 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n].cnt + " \n" + n);
        while(dp[n].idx > 0){
            sb.append(" " + dp[n].idx);
            n = dp[n].idx;
        }
        System.out.println(sb.toString());
    }
}