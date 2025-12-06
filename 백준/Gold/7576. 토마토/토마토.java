import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int un;
    static int ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static Queue<Point> ripen;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        boolean[][] visited = new boolean[n][m];
        while(!ripen.isEmpty()){
            int qSize = ripen.size();
            while(qSize --> 0){
                Point p = ripen.poll();
                visited[p.x][p.y] = true;
                for(int i=0; i<4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || arr[nx][ny]!=0) continue;
                    ripen.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    arr[nx][ny] = 1;
                    un--;
                }
            }
            ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ripen = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) un++;
                else if(arr[i][j] == 1) ripen.add(new Point(i, j));
            }
        }
        if(un == 0) {
            System.out.println(0);
            return;
        }
        bfs();
        if(un == 0) System.out.println(ans-1);
        else System.out.println(-1);
    }
}
