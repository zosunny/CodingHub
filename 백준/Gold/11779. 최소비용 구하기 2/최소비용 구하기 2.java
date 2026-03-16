import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int e;
        int c;
        Edge(int e, int c){
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Edge o){
            return this.c - o.c;
        }
    }

    static int n, m;
    static List<Edge>[] list;
    static int[] dis;
    static int[] parent;

    public static void dijk(int s, int target){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.add(new Edge(s, 0));
        dis[s] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.e]) continue;
            visited[e.e] = true;
            for(Edge edge : list[e.e]){
                if(dis[edge.e] > dis[e.e] + edge.c){
                    dis[edge.e] = dis[e.e] + edge.c;
                    parent[edge.e] = e.e;
                    pq.add(new Edge(edge.e, dis[edge.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        parent = new int[n+1];
        dijk(s, e);

        // 경로 추적
        Stack<Integer> stack = new Stack<>();
        int now = e;
        while(now != 0){
            stack.push(now);
            now = parent[now];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dis[e]).append("\n");
        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
