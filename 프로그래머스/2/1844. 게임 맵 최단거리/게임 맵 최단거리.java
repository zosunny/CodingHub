import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point{
        int x, y;
        int dis;
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    public static void bfs(int x, int y, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Point(x, y, 1));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            // 상대 팀 진영에 도착한 경우
            if(p.x == N-1 && p.y == M-1){
                // 최단거리로 스위치
                answer = Math.min(answer, p.dis);
            }
            // 4방 탐색
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int ndis = p.dis + 1;
                // 못지나가는 경우
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || maps[nx][ny]==0) continue;
                // 브루트포스 - 이동거리가 이미 최종 최단거리를 넘은 경우
                if(ndis >= answer) continue;
                // 다음 위치로 진행
                q.add(new Point(nx, ny, ndis));
                visited[nx][ny] = true;
            }
        }
    }
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        bfs(0, 0, maps);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}