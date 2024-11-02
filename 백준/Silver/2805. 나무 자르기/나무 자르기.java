import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int ans;
    static int[] arr;

    public static long calc(int mid){
        long rest = 0;
        for(int i=0; i<n; i++){
            // 절단기에 설정한 값보다 큰 나무
            if(arr[i] > mid){
                rest += (arr[i] - mid);
            }
        }
        return rest;
    }

    public static void binarySearch(int s, int e){
        if(s > e) return;
        int mid = (s + e) / 2;

        long rest = calc(mid);
        if(rest >= m) {
            ans = Math.max(ans, mid);
            binarySearch(mid+1, e);
        }
        else binarySearch(s, mid-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int tall = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            tall = Math.max(tall, arr[i]);
        }
        binarySearch(1, tall);
        System.out.println(ans);
    }
}