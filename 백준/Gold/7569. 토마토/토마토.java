import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int x, y, z;
        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int m, n, h;
    static int unripe;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] arr;
    static Queue<Point> q;

    public static void bfs(){
        boolean[][][] visited = new boolean[h][n][m];
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                Point p = q.poll();
                for(int i=0; i<6; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];
                    if(nx<0 || ny<0 || nz<0 || nx>=h || ny>=n || nz>=m || visited[nx][ny][nz]) continue;
                    // 안익은 토마토 만났을 때
                    if(arr[nx][ny][nz]==0) {
                        unripe--;
                        q.add(new Point(nx, ny, nz));
                    }
                    visited[nx][ny][nz] = true;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        q = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 0) unripe++;
                    if(arr[i][j][k] == 1) q.add(new Point(i, j, k));
                }
            }
        }
        // 모든 토마토 익어 있는 경우
        if(unripe==0) System.out.println(0);
        else{
            bfs();
            if(unripe==0) System.out.println(cnt-1);      // 토마토 모두 익은 상태
            else System.out.println(-1);                // 토마토 모두 익지 못하는 상태
        }
    }
}