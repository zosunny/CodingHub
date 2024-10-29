import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int ans;
    static int[] arr;

    public static void binarySearch(int s, int e, int target){
        if(s > e) return;
        int m = (s + e) / 2;
        int sum = 0;
        int idx = n;
        for(int i=0; i<n; i++) {
            if(arr[i] <= m) sum += arr[i];
            else {
                idx = i;
                break;
            }
        }
        sum += m * (n - idx);
        if(sum <= target){
            ans = m;
            binarySearch(m+1, e, target);
        }else binarySearch(s, m-1, target);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());
        binarySearch(1, arr[n-1], target);
        System.out.println(ans);
    }
}