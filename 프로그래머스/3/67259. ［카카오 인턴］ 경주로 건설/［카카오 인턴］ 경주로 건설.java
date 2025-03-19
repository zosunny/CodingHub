import java.util.*;

/*
    상하 or 좌우 -> 직선도로 100원
    직각 -> 코너 500원 추가
*/

class Solution {
    
    static class Point{
        int x, y;
        int d;
        int cost;
        Point(int x, int y, int d, int cost){
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
    }
    
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void dijk(int[][] board){
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // 현재 위치에서 최솟값 저장
        int[][][] visited = new int[n][n][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        pq.add(new Point(0, 0, -1, 0));
        while(!pq.isEmpty()){
            Point p = pq.poll();
            // 도착
            if(p.x == n-1 && p.y == n-1){
                ans = Math.min(ans, p.cost);
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ncost = p.cost + 100;
                if(nx<0 || ny<0 || nx>=n || ny>=n || board[nx][ny]==1) continue;
                // 코너인지 확인
                if(p.d != -1 && p.d % 2 != i % 2) ncost += 500;
                // 현 위치에서 최솟값만
                if(visited[nx][ny][i] > ncost){
                    visited[nx][ny][i] = ncost;
                    pq.add(new Point(nx, ny, i, ncost));
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        n = board.length;
        
        dijk(board);
        
        return ans;
    }
}