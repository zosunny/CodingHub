import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int[] sg;
    static int[] sy;

    public static void binarySearch(int s, int e, int target){
        if(s > e) return;
        int mid = (s + e) / 2;
        if(target == sy[mid]) {
            cnt++;
            return;
        }
        if(target < sy[mid]) {
            binarySearch(s, mid-1, target);
        }else if(target > sy[mid]){
            binarySearch(mid+1, e, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            sg = new int[n];
            for(int i=0; i<n; i++){
                sg[i] = Integer.parseInt(br.readLine());
            }

            sy = new int[m];
            for(int i=0; i<m; i++){
                sy[i] = Integer.parseInt(br.readLine());
            }

            cnt = 0;
            for(int i=0; i<n; i++){
                binarySearch(0, m-1, sg[i]);
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}