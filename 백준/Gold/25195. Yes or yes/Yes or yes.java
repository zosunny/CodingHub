import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean flag;
    static List<Integer>[] list;
    static boolean[] fan;
    static boolean[] visited;

    public static void dfs(int x){
        visited[x] = true;
        if(list[x].isEmpty()) flag = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now] || fan[now]) continue;
            dfs(now);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) list[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
        }
        fan = new boolean[n+1];
        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<s; i++){
            int idx = Integer.parseInt(st.nextToken());
            fan[idx] = true;
        }
        visited = new boolean[n+1];
        if(!fan[1]) dfs(1);
        if(flag) System.out.println("yes");
        else System.out.println("Yes");
    }
}