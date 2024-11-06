import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long ans = Long.MAX_VALUE;
    static int[] arr;

    public static void binarySearch(long s, long e){
        if(s > e) return;
        long mid = (s + e) / 2;
        long sum = 0;
        for(int i=0; i<m; i++) sum += (long)Math.ceil((double)arr[i]/(double)mid);
        if(sum > n) binarySearch(mid+1, e);
        else{
            ans = Math.min(ans, mid);
            binarySearch(s, mid-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        long max = 0;
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        binarySearch(0, max);
        System.out.println(ans);
    }
}