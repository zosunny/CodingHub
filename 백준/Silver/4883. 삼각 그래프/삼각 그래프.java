import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;

        while(true){
            int k = Integer.parseInt(br.readLine());
            if(k == 0) break;

            int[][] arr = new int[k][3];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dp = new int[3];
            dp[0] = 1000;
            dp[1] = arr[0][1];
            dp[2] = arr[0][1] + arr[0][2];

            int[] tmp = new int[3];
            for(int i=1; i<k; i++){
                if(i == 1){
                    tmp[0] = dp[1] + arr[1][0];
                    tmp[1] = Math.min(Math.min(dp[1], dp[2]), tmp[0]) + arr[1][1];
                    tmp[2] = Math.min(Math.min(dp[1], dp[2]), tmp[1]) + arr[1][2];
                }
                else{
                    tmp[0] = Math.min(dp[0], dp[1]) + arr[i][0];
                    tmp[1] = Math.min(Math.min(Math.min(dp[0], dp[1]), tmp[2]), tmp[0]) + arr[i][1];
                    tmp[2] = Math.min(Math.min(dp[1], dp[2]), tmp[1]) + arr[i][2];
                }
                dp = tmp.clone();
            }

            sb.append(idx).append(". ").append(dp[1]).append("\n");
            idx++;
        }
        System.out.println(sb.toString());
    }
}
