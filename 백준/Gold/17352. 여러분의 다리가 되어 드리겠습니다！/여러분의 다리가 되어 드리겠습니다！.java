import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] set;

    public static int find(int x){
        if(set[x] == x) return x;
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
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        set = new int[n+1];
        for(int i=1; i<n+1; i++){
            set[i] = i;
        }

        for(int i=0; i<n-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1 + " ");

        int tmp = find(1);
        for(int i=2; i<n+1; i++){
            if(find(i) != tmp) {
                sb.append(i);
                break;
            }
        }
        System.out.println(sb);
    }
}