import java.util.*;

class Solution {
    
    static class Point{
        int x, y;
        int d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static boolean bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.add(new Point(x, y, 0));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.d > 2) continue;
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nd = p.d + 1;
                if(nx<0 || ny<0 || nx>=5 || ny>=5 || visited[nx][ny]) continue;
                // 거리 2일 때 응시자 확인
                if(nd == 1 && arr[nx][ny] == 'P') return false;
                if(nd == 2 && arr[nx][ny] == 'P' && arr[p.x][p.y] != 'X') return false;
                q.add(new Point(nx, ny, nd));
                visited[nx][ny] = true;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            arr = new char[5][5];
            for(int j=0; j<5; j++){
                arr[j] = places[i][j].toCharArray();
            }
            
            // 응시자 거리 탐색
            for(int j=0; j<5; j++){
                boolean flag = true;
                for(int k=0; k<5; k++){
                    if(arr[j][k] == 'P') {
                        flag = bfs(j, k);
                        if(!flag) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if(!flag) break;
                else answer[i] = 1;
            }
        }
        
        return answer;
    }
}