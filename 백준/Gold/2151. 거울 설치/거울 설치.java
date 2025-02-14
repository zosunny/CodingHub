import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static class Point {
        int x, y;
        int prev_d;
        int mirror;
        Point(int x, int y, int prev_d, int mirror){
            this.x = x;
            this.y = y;
            this.prev_d = prev_d;
            this.mirror = mirror;
        }
    }
    static int n;
    static int startX, startY;
    static int targetX, targetY;
    static int ans = Integer.MAX_VALUE;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dijk(int x, int y){
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.mirror, o2.mirror));
        boolean[][] visited = new boolean[n][n];
        pq.add(new Point(x, y, 0, 0));
        visited[x][y] = true;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            // 도착
            if(p.x == targetX && p.y == targetY){
                ans = Math.min(ans, p.mirror);
                break;
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny] || arr[nx][ny] == '*') continue;
                // . 인 경우 이전 이동 방향 그대로 통과
                if(arr[p.x][p.y] == '.' && i == p.prev_d){
                    pq.add(new Point(nx, ny, p.prev_d, p.mirror));
                }
                // ! 인 경우 이전 이동 방향 그대로 통과 or 90도로 바뀌는 경우
                if(arr[p.x][p.y] == '!'){
                    if(i == p.prev_d) {
                        pq.add(new Point(nx, ny, p.prev_d, p.mirror));
                        visited[p.x][p.y] = true;
                    }
                    if(((p.prev_d == 0 || p.prev_d == 1) && (i == 2 || i == 3)) || ((p.prev_d == 2 || p.prev_d == 3) && (i == 0 || i == 1))) {
                        pq.add(new Point(nx, ny, i, p.mirror + 1));
                        visited[p.x][p.y] = true;
                    }
                }
                // # 인 경우 모든 방향 다 가능
                if(arr[p.x][p.y] == '#') {
                    pq.add(new Point(nx, ny, i, p.mirror));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        boolean flag = false;

        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                if(arr[i][j] == '#' && !flag) {
                    startX = i;
                    startY = j;
                    flag = true;
                }else if(arr[i][j] == '#' && flag){
                    targetX = i;
                    targetY = j;
                }
            }
        }
        dijk(startX, startY);
        System.out.println(ans);
    }
}