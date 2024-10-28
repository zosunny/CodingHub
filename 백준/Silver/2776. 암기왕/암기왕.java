import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int n, m;
    static boolean flag;
    static int[] arr;
    static StringBuilder sb;

    public static void binarySearch(int s, int e, int target){
        if(s > e) {
            sb.append("0");
            return;
        }
        int m = (s + e) / 2;
        if(arr[m] == target) {
            sb.append("1");
            return;
        }
        else if (arr[m] > target) {
            binarySearch(s, m-1, target);
        }else{
            binarySearch(m+1, e, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while(T --> 0){
            sb = new StringBuilder();
            // 수첩 1
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            // 수첩 2
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                int now = Integer.parseInt(st.nextToken());
                flag = false;
                binarySearch(0, n-1, now);
                if(i != m-1) sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}