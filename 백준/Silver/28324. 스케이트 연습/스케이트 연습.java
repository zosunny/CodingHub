import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] ans = new int[n];
        long sum = 1;
        ans[n-1] = 1;
        for(int i=n-1; i>0; i--){
            ans[i-1] = Math.min(arr[i-1], ans[i]+1);
            sum += ans[i-1];
        }
        System.out.println(sum);
    }
}