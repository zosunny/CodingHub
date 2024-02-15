import java.util.*;

class Solution {
    
    static int n, m;
    static int answer;
    static boolean flag;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int x, int y, int[][] maps){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                Point p = q.poll();
                if(p.x == n-1 && p.y == m-1) {
                    flag = true;
                    return;
                }
                for(int i=0; i<4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || maps[nx][ny]==0) continue;
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            answer++;
        }
    }
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        bfs(0, 0, maps);
        
        return flag ? answer+1 : -1;
    }
}