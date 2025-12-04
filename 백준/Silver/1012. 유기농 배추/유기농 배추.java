import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, k;
    static int ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny] || arr[nx][ny]==0) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
        ans++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t --> 0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            // bfs
            visited = new boolean[m][n];
            ans = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] == 1 && !visited[i][j]) bfs(i, j);
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
