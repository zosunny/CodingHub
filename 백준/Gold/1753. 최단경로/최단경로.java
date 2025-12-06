import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e;
    static int s;
    static List<Edge>[] list;
    static int[] dis;

    static class Edge implements Comparable<Edge>{
        int idx, w;
        Edge(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }
    }

    public static void dijk(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];
        pq.add(new Edge(start, 0));
        dis[start] = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(visited[edge.idx]) continue;
            visited[edge.idx] = true;
            for(Edge e : list[edge.idx]){
                dis[e.idx] = Math.min(dis[e.idx], dis[edge.idx] + e.w);
                pq.add(new Edge(e.idx, dis[e.idx]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());

        list = new ArrayList[v+1];
        for(int i=0; i<v+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w));
        }

        dis = new int[v+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijk(s);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<v+1; i++){
            if(dis[i] == Integer.MAX_VALUE) sb.append("INF" + "\n");
            else sb.append(dis[i] + "\n");
        }

        System.out.println(sb.toString());
    }
}
