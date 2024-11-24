import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int y;
        int d;
        Point(int y, int d){
            this.y = y;
            this.d = d;
        }
    }

    static int n;
    static int start;
    static int ans;
    static boolean[] visited;
    static List<Point>[] list;

    public static void dfs(int x, int dis){
        visited[x] = true;
        if(dis > ans){
            ans = dis;
            start = x;
        }
        for(Point p : list[x]){
            if(visited[p.y]) continue;
            dfs(p.y, dis+p.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1) break;
                int y = tmp;
                int d = Integer.parseInt(st.nextToken());
                list[x].add(new Point(y, d));
            }
        }
        // 특정 노드에서 가장 먼 노드 탐색
        visited = new boolean[n+1];
        dfs(1, 0);
        
        // 가장 먼 노드에서 시작하는 트리 지름 계산
        visited = new boolean[n+1];
        dfs(start, 0);

        System.out.println(ans);
    }
}