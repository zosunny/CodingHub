import java.util.*;

/*
  각 로봇별로 위아래, 좌우로 이동하며 경로 리스트 배열에 저장
  최종 리스트 '매 초별' 탐색하면서 로봇 별 이동한 좌표에 ++, 좌표 탐색해서 2이상이면 충돌 카운트
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
    static List<Point>[] list;
    
    public static void move(int x, int y, int tx, int ty, int i){
        // 상하탐색
        while(x != tx){
            if(x < tx){
                x++;
            }else{
                x--;
            }
            list[i].add(new Point(x, y));
        }
        // 좌우탐색
        while(y != ty){
            if(y < ty){
                y++;
            }else{
                y--;
            }
            list[i].add(new Point(tx, y));
        }
    }
    
    public static void calc(){
        int[][] visited = new int[101][101];
        int cnt = n;
        while(cnt > 0){
            visited = new int[101][101];
            cnt = n;
            // 각 로봇들의 첫번째 이동 좌표 표시
            for(int i=0; i<n; i++){
                if(list[i].size() == 0) {
                    cnt--;
                    continue;
                }
                Point p = list[i].get(0);
                visited[p.x][p.y]++;
                list[i].remove(0);
            }
            // 충돌 탐색
            for(int i=1; i<101; i++){
                for(int j=1; j<101; j++){
                    if(visited[i][j] >= 2) ans++;
                }
            }
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        n = routes.length;
        m = routes[0].length;
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m-1; j++){
                int s = routes[i][j] - 1;
                int e = routes[i][j+1] - 1;
                // 각 로봇의 시작 좌표만 저장
                if(j == 0){
                    list[i].add(new Point(points[s][0], points[s][1]));
                }
                move(points[s][0], points[s][1], points[e][0], points[e][1], i);
            }
        }
        
        calc();
        
        return ans;
    }
}