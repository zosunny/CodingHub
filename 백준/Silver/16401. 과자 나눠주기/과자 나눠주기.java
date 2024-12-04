import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static long ans;
    static int[] arr;

    public static boolean calc(long mid){
        long tmp = 0;
        for(int i=0; i<n; i++){
            tmp += arr[i] / mid;
        }
        if(tmp >= m) return true;
        else return false;
    }

    public static void binarySerch(long s, long e){
        if(s > e) return;
        long mid = (s + e) / 2;
        if(calc(mid)) {
            ans = Math.max(ans, mid);
            binarySerch(mid+1, e);
        }
        else binarySerch(s, mid-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        binarySerch(1, arr[n-1]);

        System.out.println(ans);
    }
}