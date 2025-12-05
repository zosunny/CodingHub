import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
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

    public static void dijk(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Edge(s, 0));
        dis[s] = 0;
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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijk(s);

        System.out.println(dis[t]);
    }
}
