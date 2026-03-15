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

    static int w;
    static int h;
    static int ans;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> fire;

    public static void bfs(int s, int e){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        q.add(new Point(s, e));
        visited[s][e] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            // 1) 불 먼저 번짐
            int fireSize = fire.size();
            while(fireSize --> 0){
                Point f = fire.poll();
                for(int i=0; i<4; i++){
                    int nx = f.x + dx[i];
                    int ny = f.y + dy[i];
                    if(nx<0 || ny<0 || nx>=h || ny>=w || arr[nx][ny]=='*' || arr[nx][ny]=='#') continue;
                    fire.add(new Point(nx, ny));
                    arr[nx][ny] = '*';
                }
            }
            // 2) 상근이 이동
            int qSize = q.size();
            while(qSize --> 0){
                Point p = q.poll();
                if(p.x==0 || p.x==h-1 || p.y==0 || p.y==w-1){
                    ans = Math.min(ans, cnt);
                }
                for(int i=0; i<4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx<0 || ny<0 || nx>=h || ny>=w || arr[nx][ny]=='*' || arr[nx][ny]=='#' || visited[nx][ny]) continue;
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            fire = new LinkedList<>();
            ans = Integer.MAX_VALUE;
            int s = 0;
            int e = 0;
            for(int i=0; i<h; i++){
                String tmp = br.readLine();
                for(int j=0; j<w; j++){
                    arr[i][j] = tmp.charAt(j);
                    if(arr[i][j] == '@') {
                        s = i;
                        e = j;
                    }
                    if(arr[i][j] == '*'){
                        fire.add(new Point(i, j));
                    }
                }
            }

            bfs(s, e);

            if(ans == Integer.MAX_VALUE) sb.append("IMPOSSIBLE" + "\n");
            else sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
