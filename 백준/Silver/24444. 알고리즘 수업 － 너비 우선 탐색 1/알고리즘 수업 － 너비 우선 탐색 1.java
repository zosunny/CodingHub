import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int n, m, r;
    static int cnt;
    static int[] visited;
    static List<Integer>[] list;

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = ++cnt;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<list[p].size(); i++){
                int now = list[p].get(i);
                if(visited[now] != 0) continue;
                q.add(now);
                visited[now] = ++cnt;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i=0; i<n+1; i++){
            Collections.sort(list[i]);
        }

        visited = new int[n+1];
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(visited[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}