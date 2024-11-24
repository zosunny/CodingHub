import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int y, d;
        Point(int y, int d){
            this.y = y;
            this.d = d;
        }
        @Override
        public int compareTo(Point o){
            int tmp = this.d - o.d;
            if(tmp == 0) tmp = this.y - o.y;
            return tmp;
        }
    }

    static int v, e;
    static int start;
    static List<Point>[] list;
    static int[] dist;

    public static void bfs(int x){
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(Point now : list[p.y]){
                // 기존 보다 짧을 때만 추가
                if((p.d + now.d) < dist[now.y]){
                    dist[now.y] = p.d + now.d;
                    q.add(new Point(now.y, p.d+now.d));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        list = new ArrayList[v+1];
        for(int i=0; i<v+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[x].add(new Point(y, d));
        }

        // 거리를 기준으로 오름차순 정렬
        for(int i=0; i<v+1; i++){
            Collections.sort(list[i]);
        }

        // 각 거리 초기화
        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        bfs(start);

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<v+1; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF" + "\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}