import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        int ans = 0;
        for(int i=0; i<X; i++){
            ans += arr[i];
        }

        int[] dp = new int[N];
        dp[X-1] = ans;

        // 슬라이딩윈도우
        int s = 0;
        int e = X;
        int tmp = ans;
        while(e < N){
            tmp -= arr[s];
            tmp += arr[e];
            ans = Math.max(ans, tmp);
            dp[e] = tmp;
            s++;
            e++;
        }
        if(ans == 0) System.out.println("SAD");
        else {
            int cnt = 0;
            for(int x : dp){
                if(x == ans) cnt++;
            }
            System.out.println(ans + " \n" + cnt);
        }
    }
}
