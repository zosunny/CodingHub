import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] select;

    public static void combi(int start, int cnt){
        if(cnt == m){
            for(int i=0; i<n; i++){
                if(select[i]) sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<n; i++){
            if(select[i]) continue;
            select[i] = true;
            combi(i+1, cnt+1);
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
        combi(0, 0);

        System.out.println(sb);
    }
}