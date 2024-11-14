import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int[] dis = new int[n-1];
        for(int i=0; i<n-1; i++) dis[i] = arr[i+1] - arr[i];
        Arrays.sort(dis);
        int cnt = 0;
        int ans = 0;
        for(int i=n-1; i>=0; i--){
            if(cnt < k) {
                cnt++;
                continue;
            }
            else ans += dis[i];
        }
        System.out.println(ans);
    }
}