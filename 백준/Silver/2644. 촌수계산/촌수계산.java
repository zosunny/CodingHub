import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int s, e;
    static int ans = -1;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void dfs(int x, int target, int cnt){
        visited[x] = true;
        if(x == target){
            ans = cnt;
        }
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            dfs(now, target, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());       // 촌수계산 시작번호
        e = Integer.parseInt(st.nextToken());       // 촌수계산 끝번호
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        visited = new boolean[n+1];
        dfs(s, e, 0);
        System.out.println(ans);
    }
}