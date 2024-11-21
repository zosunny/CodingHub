import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int color;
        int x, y;
        int cnt;
        Point(int color, int x, int y, int cnt){
            this.color = color;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Point o){
            int tmp = this.y - o.y;
            if(tmp == 0) tmp = this.x - o.x;
            return tmp;
        }
    }

    static boolean flag;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};
    static boolean[][] visited;
    static boolean[][] not;
    static PriorityQueue<Point> pq;
    static StringBuilder sb;

    public static void dfs(int x, int y, int color, int d, int cnt){
        int nx = x + dx[d];
        int ny = y + dy[d];
        int ncnt = cnt + 1;
        // 탐색 제외 조건
        if(nx<0 || ny<0 || nx>=19 || ny>=19 || visited[nx][ny] || arr[nx][ny]!=color) {
            // 6목 이상인 경우 마지막 바둑알 좌표
            if(ncnt > 5) not[x][y] = true;
            // 같은 색의 바둑알이 5개인 경우
            if(ncnt == 5) {
                // 6목이 아닌 경우
                if(!not[x][y]) flag = true;
            }
            return;
        }
        dfs(nx, ny, color, d, ncnt);
        if(flag) return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        arr = new int[19][19];
        pq = new PriorityQueue<>();
        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 검은색 또는 흰색 바둑알 위치 저장
                if(arr[i][j] == 1 || arr[i][j] == 2) pq.add(new Point(arr[i][j], i, j, 0));
            }
        }
        not = new boolean[19][19];
        while(!pq.isEmpty()){
            Point p = pq.poll();
            visited = new boolean[19][19];
            visited[p.x][p.y] = true;
            for(int d=0; d<4; d++){
                dfs(p.x, p.y, p.color, d, p.cnt);
                if(flag) {
                    sb.append(p.color + "\n" + (p.x+1) + " " + (p.y+1));
                    System.out.println(sb.toString());
                    return;
                }
            }
        }
        System.out.println(0);
    }
}