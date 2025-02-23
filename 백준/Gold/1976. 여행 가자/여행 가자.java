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

    public static void union(int i, int j){
        int a = find(i);
        int b = find(j);

        if(a < b) set[b] = a;
        else if(a > b) set[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        set = new int[n+1];
        for(int i=1; i<n+1; i++){
            set[i] = i;
        }

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int a = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++){
            if(a != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}