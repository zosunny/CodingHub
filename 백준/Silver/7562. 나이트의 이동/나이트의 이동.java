import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int l;
    static StringBuilder sb;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void bfs(int x, int y, int ex, int ey){
        boolean[][] visited = new boolean[l][l];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                Point p = q.poll();
                if(p.x == ex && p.y == ey) sb.append(cnt + "\n");
                for(int i=0; i<8; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx<0 || ny<0 || nx>=l || ny>=l || visited[nx][ny]) continue;
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while(t --> 0){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            bfs(x, y, ex, ey);
        }
        System.out.println(sb.toString());
    }
}