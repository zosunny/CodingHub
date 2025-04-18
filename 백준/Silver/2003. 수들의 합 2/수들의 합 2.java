import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int i = 0;
        int tmp = 0;
        
        for(int j=0; j<n; j++){
            tmp += arr[j];          // 누적합
            // 투 포인터
            while(tmp > m){
                tmp -= arr[i];
                i++;
            }
            if(tmp == m) ans++;
        }
        System.out.println(ans);
    }
}