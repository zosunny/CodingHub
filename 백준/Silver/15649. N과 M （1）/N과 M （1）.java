import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringBuilder sb;

    public static void permu(int cnt, int[] input, boolean[] select){
        if(cnt == m) {
            for(int x : input){
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<n+1; i++){
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            permu(cnt+1, input, select);
            select[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = i;
        }

        int[] input = new int[m];
        boolean[] select = new boolean[n+1];
        permu(0, input, select);

        System.out.println(sb.toString());
    }
}
