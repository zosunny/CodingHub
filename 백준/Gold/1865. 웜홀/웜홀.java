import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int x, y;
        int d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int n, m, w;
    static final int INF = Integer.MAX_VALUE;
    static List<Point> list;
    static int[] dis;

    public static boolean bellmanford(){
        dis[0] = 0;
        // n-1 만큼 최단거리 구하기
        for(int i=0; i<n; i++){
            for(Point p : list){
                if(dis[p.x] != INF && dis[p.y] > dis[p.x] + p.d){
                    dis[p.y] = dis[p.x] + p.d;
                }
            }
        }
        // 음의 싸이클 확인
        for(Point p : list){
            if(dis[p.x] != INF && dis[p.y] > dis[p.x] + p.d) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());       // 노드 수
            m = Integer.parseInt(st.nextToken());       // 간선 수
            w = Integer.parseInt(st.nextToken());       // 웜홀 수
            list = new ArrayList<>();
            // 간선 정보
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list.add(new Point(s, e, d));
                list.add(new Point(e, s, d));
            }
            // 웜홀 정보
            for(int i=0; i<w; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list.add(new Point(s, e, -d));
            }
            // 가상의 0번 노드 모든 정점과 연결
            for(int i=1; i<n+1; i++){
                list.add(new Point(0, i, 0));
            }
            dis = new int[n+1];
            Arrays.fill(dis, INF);
            if(bellmanford()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}