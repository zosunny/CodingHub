import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] set;

    public static int find(int x){
        if(x == set[x]) return x;
        else return set[x] = find(set[x]);
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a < b) set[b] = a;
        else if(a > b) set[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new int[n+1];
        for(int i=1; i<n+1; i++){
            set[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int[] time = new int[n];
        for(int i=0; i<n; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<n-1; i++){
            int x = find(time[i]);
            int y = find(time[i+1]);
            if(x != y) ans++;
        }

        System.out.println(ans);
    }
}