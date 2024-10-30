import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;

    public static boolean calc(int mid){
        int sum = 0;
        int cnt = 1;
        for(int i=0; i<n; i++){
            if(arr[i] > mid) return true;
            if(sum + arr[i] > mid) {
                cnt++;
                sum = arr[i];
            }else sum += arr[i];
        }
        if(cnt > m) return true;
        else {
            ans = Math.min(ans, mid);
            return false;
        }
    }

    public static void binarySearch(int s, int e, int m){
        if(s > e) return;
        int mid = (s + e) / 2;
        if(calc(mid)){
            binarySearch(mid+1, e, m);
        }else{
            binarySearch(s, mid-1, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
        }
        binarySearch(1, end, m);
        System.out.println(ans);
    }
}