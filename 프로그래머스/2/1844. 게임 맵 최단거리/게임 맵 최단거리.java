import java.util.*;

class Solution {
    
    static class Point{
        int x, y, dis;
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    static int answer;
    static int N;
    static int M;
    static int minDis = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void bfs(int x, int y, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Point(x, y, 1));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            // System.out.println("시작점: " + p.x + ", " + p.y + " => " + p.dis);
            // 도착했을 때 빠른 길 갱신
            if(p.x == N-1 && p.y == M-1) {
                minDis = Math.min(minDis, p.dis);
                // System.out.println("도착");
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ndis = p.dis + 1;
                if(nx<0 || ny<0 || nx>=N || ny>=M || maps[nx][ny]==0 || visited[nx][ny]) continue;
                if(ndis >= minDis) continue;
                // System.out.println(nx + ", " + ny + " => " + ndis);
                q.add(new Point(nx, ny, ndis));
                visited[nx][ny] = true;
            }
        }
    }
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        bfs(0, 0, maps);
        
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}