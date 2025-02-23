import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] set;

    public static int find(int x){
        if(set[x] == x) return x;
        else return set[x] = find(set[x]);
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a < b) set[b] = a;
        else if(b < a) set[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기 집합
        set = new int[n+1];
        for(int i=0; i<n+1; i++){
            set[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(type == 0) union(x, y);
            else {
                if(find(x) == find(y)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}