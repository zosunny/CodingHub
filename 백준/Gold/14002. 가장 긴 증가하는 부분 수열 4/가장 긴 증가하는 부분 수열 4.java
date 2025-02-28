import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int len = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    len = Math.max(len, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");

        // 스택으로 역추적
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i] == len) {
                s.push(arr[i]);
                len--;
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop() + " ");
        }

        System.out.println(sb);
    }
}