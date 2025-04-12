import java.util.*;

/*
    n, m
    시추관 수직으로 1개 -> 가장 많은 석유 뽑는 시추관 위치
    
    bfs로 열별 석유수 저장
    최대 n*m만큼 탐색 -> 500 * 500
*/

class Solution {
    
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int n, m;
    static int ans;
    static int[] col;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void bfs(int x, int y, int[][] land){
        Queue<Point> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new Point(x, y));
        set.add(y);
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || land[nx][ny]==0) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                set.add(ny);
                cnt++;
            }
        }
        // 해당 열에 석유량 추가
        for(int c : set){
            col[c] += cnt;
        }
    }
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        col = new int[m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && land[i][j] == 1) bfs(i, j, land);
            }
        }
        
        for(int x : col){
            ans = Math.max(ans, x);
        }
        
        return ans;
    }
}