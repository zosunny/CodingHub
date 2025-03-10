import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;
        for(int i=0; i<k; i++){
            tmp += arr[i];
        }

        int ans = tmp;
        for(int i=k; i<n; i++){
            tmp -= arr[i-k];
            tmp += arr[i];
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}