import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] set;

    public static int find(int x){
        if(set[x] == x) return x;
        else return set[x] = find(set[x]);
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a < b) set[b] = a;
        else set[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<T+1; t++){
            sb.append("Scenario " + t + ":").append("\n");

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            // 부모 집합
            set = new int[n+1];
            for(int i=1; i<n+1; i++){
                set[i] = i;
            }

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }

            int m = Integer.parseInt(br.readLine());

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int a = find(x);
                int b = find(y);

                if(a == b) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}