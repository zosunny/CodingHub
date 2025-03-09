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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new int[n];
        for(int i=0; i<n; i++){
            set[i] = i;
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 싸이클 확인
            if(find(x) == find(y)) {
                ans = i + 1;
                break;
            }
            union(x, y);
        }
        System.out.println(ans);
    }
}