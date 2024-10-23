import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int y, dis;
        Point(int y, int dis){
            this.y = y;
            this.dis = dis;
        }
    }

    static int N;
    static int M;
    static int ans;
    static List<Point>[] list;
    static boolean[] visited;

    public static void dfs(int s, int e, int res){
        // 목적 노드에 도착
        if(s == e){
            ans = res;
            return;
        }
        visited[s] = true;
        for(int i=0; i<list[s].size(); i++){
            int nnode = list[s].get(i).y;
            int ndis = list[s].get(i).dis;
            if(visited[nnode]) continue;
            dfs(nnode, e, res+ndis);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new LinkedList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new LinkedList<>();
        }
        // 거리를 포함한 list 생성
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list[x].add(new Point(y, dis));
            list[y].add(new Point(x, dis));
        }
        // M개의 두 노드 사이의 거리
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ans = 0;
            visited = new boolean[N+1];
            dfs(s, e, 0);
            System.out.println(ans);
        }
    }
}