import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static long ans;
    static long[] arr;

    public static boolean calc(long mid){
        int cnt = 0;
        for(int i=0; i<n; i++){
            cnt += arr[i] / mid;
        }
        if(cnt >= k) return true;
        else return false;
    }

    public static void binarySearch(long s, long e){
        if(s > e) return;
        long mid = (s + e) / 2;
        if(calc(mid)){
            ans = Math.max(ans, mid);
            binarySearch(mid+1, e);
        }else binarySearch(s, mid-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        binarySearch(1, arr[n-1]);
        System.out.println(ans);
    }
}