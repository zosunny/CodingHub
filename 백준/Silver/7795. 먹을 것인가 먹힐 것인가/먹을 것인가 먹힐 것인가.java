import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int n, m;
    static int idx;
    static int ans;
    static int[] arr;

    public static void binarySearch(int s, int e, int target){
        if(s > e) return;
        int m = (s + e) / 2;
        if(arr[m] <= target){
            idx = m + 1;
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
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                int now = Integer.parseInt(st.nextToken());
                idx = 0;
                binarySearch(0, n-1, now);
                ans += (n - idx);
            }
            System.out.println(ans);
        }
    }
}