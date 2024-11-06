import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point{
        int x, dis;
        Point(int x, int dis){
            this.x = x;
            this.dis = dis;
        }
    }

    static int n, m, k, x;
    static List<Integer>[] list;
    static PriorityQueue<Integer> pq;

    public static void bfs(){
        boolean[] visited = new boolean[n+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, 0));
        visited[x] = true;
        boolean flag = false;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<list[p.x].size(); i++){
                int nx = list[p.x].get(i);
                int ndis = p.dis + 1;
                if(visited[nx]) continue;
                // 최단 거리가 K면 저장하고 q에 넣지 않음.
                if(ndis == k) {
                    flag = true;
                    pq.add(nx);
                }
                else q.add(new Point(nx, ndis));
                visited[nx] = true;
            }
        }
        // 최단 거리 K로 도달할 수 있는 도시가 없는 경우
        if(!flag) pq.add(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 도시 개수
        m = Integer.parseInt(st.nextToken());   // 도로 개수
        k = Integer.parseInt(st.nextToken());   // 거리 정보
        x = Integer.parseInt(st.nextToken());   // 출발 도시 번호

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
        }
        bfs();
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}