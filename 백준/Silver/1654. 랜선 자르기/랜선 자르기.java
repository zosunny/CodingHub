import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static long ans = Long.MIN_VALUE;
    static int[] arr;

    public static int calc(long len){
        int tmp = 0;
        for(int i=0; i<K; i++){
            tmp += arr[i] / len;
        }
        return tmp;
    }

    public static void binarySearch(long s, long e){
        if(s > e) return;
        long mid = (s + e) / 2;
        if(calc(mid) >= N){
            ans = Math.max(ans, mid);
            binarySearch(mid+1, e);
        }
        else binarySearch(s, mid-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        binarySearch(1, arr[K-1]);

        System.out.println(ans);
    }
}
