import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int ans;
    static int[] arr;

    public static int calc(int dis){
        int now = arr[0];
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(arr[i] - now >= dis) {
                cnt++;
                now = arr[i];
            }
        }
        return cnt;
    }

    public static void binarySearch(int s, int e){
        if(s > e) return;
        int mid = (s + e) / 2;
        if(calc(mid) >= C){
            ans = Math.max(ans, mid);
            binarySearch(mid+1, e);
        }else {
            binarySearch(s, mid-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr[0] = Integer.parseInt(br.readLine());
        int minD = Integer.MAX_VALUE;
        for(int i=1; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            minD = Math.min(minD, arr[i] - arr[i-1]);
        }
        Arrays.sort(arr);

        binarySearch(minD, arr[N-1] - arr[0]);

        System.out.println(ans);
    }
}
