import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static long N;
    static long ans;

    public static void binarySearch(long s, long e, long target){
        if(s > e) return;
        long m = (s + e) / 2;
        long sum = m * (m + 1) / 2;
        if(sum <= target) {
            ans = m;
            binarySearch(m+1, e, target);
        }else{
            binarySearch(s, m-1, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            binarySearch(0, (long)Math.sqrt(2*N-1), N);
            System.out.println(ans);
        }
    }
}