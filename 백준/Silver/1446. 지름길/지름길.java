import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int x, y;
        int dis;
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        @Override
        public int compareTo(Point o){
            return this.dis - o.dis;
        }
    }

    static int N;
    static int D;
    static List<Point>[] list;
    static int[] dis;

    public static void dijk(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        dis[0] = 0;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            for(Point now : list[p.y]){
                // now.y 까지의 거리가 이전보다 작으면
                if(dis[now.y] > dis[p.y] + now.dis){
                    dis[now.y] = dis[p.y] + now.dis;
                    pq.add(new Point(now.x, now.y, dis[now.y]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList[D+1];
        for(int i=0; i<D+1; i++){
            list[i] = new ArrayList<>();
        }

        // 기본 도로 추가
        for(int i=0; i<D; i++){
            list[i].add(new Point(i, i+1, 1));
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(y <= D) list[x].add(new Point(x, y, d));
        }

        dis = new int[D+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dijk();

        System.out.println(dis[D]);
    }
}