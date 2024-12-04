import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] select;
    static StringBuilder sb;

    public static void permu(int cnt, int[] input){
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(input[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(select[i]) continue;
            input[cnt] = arr[i];
            select[i] = true;
            permu(cnt+1, input);
            select[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        select = new boolean[n];
        int[] input = new int[m];
        permu(0, input);

        System.out.println(sb.toString());
    }
}