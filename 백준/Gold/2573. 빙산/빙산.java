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

    static int n, m;
    static int year;
    static int[][] arr;
    static int[][] copy;
    static Queue<Point> ice;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int melting(){
        while(!ice.isEmpty()){
            Point p = ice.poll();
            int cnt = 0;
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(arr[nx][ny] == 0) cnt++;
            }
            // 0개수 만큼 높이 감소 (최소 0)
            copy[p.x][p.y] -= cnt;
            if(copy[p.x][p.y] < 0) copy[p.x][p.y] = 0;
        }
        return 1;
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
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || arr[nx][ny]==0) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ice = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) ice.add(new Point(i, j));
            }
        }

        while(true){
            // 1. 빙하 녹이기
            copy = deepcopy(arr);
            year += melting();

            arr = deepcopy(copy);
            // 2. 빙하 덩어리 수 구하기
            visited = new boolean[n][m];
            int num = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(visited[i][j]) continue;
                    if(arr[i][j] != 0) {
                        bfs(i, j);
                        num++;
                    }
                }
            }
            if(num >= 2) break;

            // 3. 다시 빙하 찾기
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j] != 0) ice.add(new Point(i, j));
                }
            }
            
            // 4. 분리되지 않고 다 녹은 경우
            if(ice.isEmpty()){
                year = 0;
                break;
            }
        }
        System.out.println(year);
    }

    // 깊은 복사 배열
    public static int[][] deepcopy(int[][] arr){
        int[][] copy = new int[arr.length][arr[0].length];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
}