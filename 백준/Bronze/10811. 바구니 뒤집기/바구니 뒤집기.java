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
        for(int i=1; i<n+1; i++){
            arr[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] copy = new int[n+1];
            for(int j=1; j<n+1; j++){
                copy[j] = arr[j];
            }
            for(int j=a; j<=b; j++){
                arr[j] = copy[b-j+a];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}