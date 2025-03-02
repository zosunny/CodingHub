import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long combi(int m, int n){
        if(n == 0 || m == n) return 1;

        long tmp = 1;
        for(int i=0; i<n; i++){
            tmp *= (m - i);
            tmp /= (i + 1);
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long res = combi(m, n);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}