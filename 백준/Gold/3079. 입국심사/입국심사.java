import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long ans = Long.MAX_VALUE;
    static int[] arr;

    // 가능한 처리 인원
    public static long calc(long mid){
        long total = 0;
        for(int i=0; i<n; i++){
            total += mid / arr[i];
            if(total > 1000000000) break;
        }
        return total;
    }

    public static void binarySearch(long s, long e){
        if(s > e) return;
        long mid = s + (e - s) / 2;
        long total = calc(mid);
        if(total >= m) {
            ans = Math.min(ans, mid);
            binarySearch(s, mid-1);
        }else binarySearch(mid+1, e);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        binarySearch(1, (long)m*arr[n-1]);
        System.out.println(ans);
    }
}