import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point>{
        int x, y;
        int cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Point o){
            return this.cnt - o.cnt;
        }
    }

    static int N, M;
    static int ans;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];
        pq.add(new Point(0, 0, 0));
        visited[0][0] = true;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            // 탈출
            if(p.x == M-1 && p.y == N-1){
                ans = p.cnt;
                break;
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=M || ny>=N || visited[nx][ny]) continue;
                // 벽을 부숴야할 때
                if(arr[nx][ny] == 1) pq.add(new Point(nx, ny, p.cnt+1));
                // 빈 방일 때
                else pq.add(new Point(nx, ny, p.cnt));
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N==1 && M==1) {
            System.out.println(0);
            return;
        }

        arr = new int[M][N];
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        bfs();

        System.out.println(ans);
    }
}
