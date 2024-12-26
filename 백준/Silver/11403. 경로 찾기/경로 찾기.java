import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] list;
    static int[][] visited;

    public static void dfs(int start, int n){
        for(int i=0; i<list[n].size(); i++){
            int now = list[n].get(i);
            if(visited[start][now] == 1) continue;
            visited[start][now] = 1;
            dfs(start, now);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) list[i].add(j);
            }
        }

        visited = new int[n][n];
        for(int i=0; i<n; i++){
            dfs(i, i);
        }

        for(int[] x : visited){
            for (int y : x){
                sb.append(y + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}