import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static boolean flag;
    static List<Integer>[] list;

    public static void dfs(int x, int[] visited){
        for(int nx : list[x]){
            if(visited[nx] != 0 && visited[nx] == visited[x]){
                flag = true;
                return;
            }
            if(visited[nx] != 0) continue;
            if(visited[x] == 1) visited[nx] = -1;
            else visited[nx] = 1;
            dfs(nx, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v+1];
            for(int j=0; j<v+1; j++){
                list[j] = new ArrayList<>();
            }
            // 양방향 리스트 연결
            for(int j=0; j<e; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            int[] visited = new int[v+1];
            flag = false;
            for(int j=1; j<v+1; j++){
                if(visited[j] != 0) continue;
                visited[j] = 1;
                dfs(j, visited);
                if(flag) break;
            }
            if(flag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        System.out.println(sb.toString());
    }
}