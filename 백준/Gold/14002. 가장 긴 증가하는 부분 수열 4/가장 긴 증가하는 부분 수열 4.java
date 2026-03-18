import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int lis = 1;
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                lis = Math.max(lis, dp[i]);
            }
        }
        sb.append(lis).append("\n");

        Stack<Integer> s = new Stack<>();
        for(int i=N-1; i>=0; i--){
            if(dp[i] == lis){
                s.push(arr[i]);
                lis--;
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}
