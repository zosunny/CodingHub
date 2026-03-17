import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int e;
        long w;
        Edge(int e, long w){
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return Long.compare(this.w, o.w);
        }
    }

    static int N, M, K;
    static List<Edge>[] list;
    static PriorityQueue<Edge> pq;
    static long[] dis;

    public static void dijk(){
        boolean[] visited = new boolean[N+1];
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.e]) continue;
            visited[e.e] = true;
            for(Edge edge : list[e.e]){
                if(dis[edge.e] > dis[e.e] + edge.w){
                    dis[edge.e] = dis[e.e] + edge.w;
                    pq.add(new Edge(edge.e, dis[edge.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[e].add(new Edge(s, w));
        }

        dis = new long[N+1];
        Arrays.fill(dis, Long.MAX_VALUE / 2);

        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int tmp = Integer.parseInt(st.nextToken());
            pq.add(new Edge(tmp, 0L));
            dis[tmp] = 0L;
        }

        dijk();

        long cnt = 0L;
        int city = 0;
        for(int i=1; i<N+1; i++){
            if(cnt < dis[i]){
                cnt = dis[i];
                city = i;
            }
        }

        System.out.println(city + "\n" + cnt);
    }
}
