import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        for(int i=0; i<k+1; i++){
            for(int j=0; j<n; j++){
                if(i < arr[j]) continue;
                if(i == arr[j]) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i-arr[j]] + 1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE - 1){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }
    }
}