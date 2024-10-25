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

    static int N, M;
    static int ans;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] arr;
    static Queue<Point> cloud;

    public static void magic(int dir, int dis){
        Queue<Point> cwater = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        while(!cloud.isEmpty()){
            Point p = cloud.poll();
            int nx = Math.abs(p.x + dx[dir] * dis + N) % N;
            int ny = Math.abs(p.y + dy[dir] * dis + N) % N;
            arr[nx][ny] += 1;
            cwater.add(new Point(nx, ny));
            check[nx][ny] = true;
        }
        while(!cwater.isEmpty()){
            Point p = cwater.poll();
            int cnt = 0;
            for(int i=0; i<4; i++){
                int nx = p.x + dx[1+2*i];
                int ny = p.y + dy[1+2*i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(arr[nx][ny] != 0) cnt++;
            }
            arr[p.x][p.y] += cnt;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] >= 2 && !check[i][j]) {
                    cloud.add(new Point(i, j));
                    arr[i][j] -= 2;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new LinkedList<>();
        cloud.add(new Point(N-1, 0));
        cloud.add(new Point(N-1, 1));
        cloud.add(new Point(N-2, 0));
        cloud.add(new Point(N-2, 1));

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken()) % N;
            magic(dir, dis);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans += arr[i][j];
            }
        }
        System.out.println(ans);
    }
}