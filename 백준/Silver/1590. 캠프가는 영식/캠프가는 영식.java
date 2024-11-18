import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, t;
    static int s, l, c;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void binarySearch(int s, int e){
        if(s > e) return;
        int mid = (s + e) / 2;
        // 영식이 도착 시간보다 작으면 안됨
        if(arr[mid] >= t) {
            ans = Math.min(ans, arr[mid]-t);
            binarySearch(s, mid-1);
        }else binarySearch(mid+1, e);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new int[c];
            for(int j=0; j<c; j++) arr[j] = s + (l * j);
            binarySearch(0, c-1);
        }
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}