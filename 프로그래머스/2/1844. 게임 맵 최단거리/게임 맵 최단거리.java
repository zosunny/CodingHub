import java.util.*;

/*
    상대팀 진영 도착위해 지나가야 하는 칸의 개수의 최솟값, 도착할 수 없으면 -1
    0: 벽, 1: 길
    (0, 0) -> (n-1, m-1)
*/

class Solution {
    
    static class Point{
        int x, y;
        int dis;
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    static int n;
    static int m;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == n-1 && p.y == m-1){
                ans = Math.min(ans, p.dis);
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ndis = p.dis + 1;
                if(nx<0 || ny<0 || nx>=n || ny>=m || maps[nx][ny]==0 || visited[nx][ny]) continue;
                if(ndis >= ans) continue;
                q.add(new Point(nx, ny, ndis));
                visited[nx][ny] = true;
            }
        }
    }
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        bfs(maps);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}