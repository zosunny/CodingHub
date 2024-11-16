import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;

    public static boolean calc(int mid){
        // 맨 앞 비추는 지 확인
        int left = arr[0] - mid;
        int right = arr[0] + mid;
        if(left > 0) return false;
        // 다음 가로등의 왼쪽 불빛이 이전 가로등의 오른쪽보다 크면 안됨
        for(int i=1; i<m; i++){
            int nLeft = arr[i] - mid;
            int nRight = arr[i] + mid;
            if(nLeft > right) return false;
            left = nLeft;
            right = nRight;
        }
        // 맨 뒤 비추는 지 확인
        if(right < n) return false;
        return true;
    }

    public static void binarySearch(int s, int e){
        if(s > e) return;
        int mid = (s + e) / 2;
        if(calc(mid)) {
            ans = Math.min(ans, mid);
            binarySearch(s, mid-1);
        }
        else binarySearch(mid+1, e);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[m];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        binarySearch(1, n);
        System.out.println(ans);
    }
}