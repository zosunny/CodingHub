import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for(int j=s; j<=e; j++){
                arr[j] = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}