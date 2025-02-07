import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);


        int lis = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] +1);
            }
            lis = Math.max(lis, dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n");

        // 스택 사용해서 역추적
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i] == lis) {
                s.add(arr[i]);
                lis--;
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}