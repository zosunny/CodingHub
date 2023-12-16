import java.util.*;

class Solution {
    
    static int cnt;
    static boolean result;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point{
        int x;
        int y;
        int desk;
        int dis;
        Point(int x, int y, int desk, int dis){
            this.x = x;
            this.y = y;
            this.desk = desk;
            this.dis = dis;
        }
    }
    
    public static void bfs(int x, int y, int desk, int dis){
        Queue<Point> q = new LinkedList<>();
        System.out.println("bfs시작: (" + x + ", " + y + ")");
        q.add(new Point(x, y, desk, dis));
        visited[x][y] = true;
        while(!q.isEmpty()){ 
            int qSize = q.size();
            for(int t=0; t<qSize; t++){
                Point p = q.poll();
                for(int i=0; i<4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int ndesk = p.desk;
                    int ndis = p.dis + 1;
                    if(nx<0 || ny<0 || nx>=5 || ny>=5 || visited[nx][ny]) continue;
                    System.out.println("(" + p.x + ", " + p.y + ")" + "-> (" + nx + ", " + ny + ") 이고, " + "ndesk: " + ndesk + ", ndis: " + ndis);
                    // 거리가 2면 조건 체크
                    if(ndis == 2){
                        // 현재 위치가 P이고 desk가 1이면 종료
                        if(arr[nx][ny] == 'P' && ndesk == 1){
                            result = true;
                            return;
                        }
                    }else{
                        // 학생이 있으면 종료
                        if(arr[nx][ny] == 'P'){
                            System.out.println("(" + nx + ", " + ny + ") : 학생자리");
                            result = true;
                            return;
                        }
                        // 빈테이블이 있으면 desk+1
                        else if(arr[nx][ny] == 'O'){
                            System.out.println("(" + nx + ", " + ny + ") : 빈테이블자리");
                            ndesk += 1;
                        }
                        q.add(new Point(nx, ny, ndesk, ndis));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // places에서 대기실 한개를 2차원 배열로 변환해 체크
        String[] tmp = new String[5];
        for(int i=0; i<5; i++){
            tmp = places[i];
            arr = new char[5][5];
            for(int j=0; j<5; j++){
                arr[j] = tmp[j].toCharArray();
            }
            for(char[] x : arr){
                for(char y : x){
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            
            // 학생자리에서 거리2까지 탐색
            result = false;
            for(int m=0; m<5; m++){
                for(int n=0; n<5; n++){
                    if(arr[m][n] == 'P'){
                        visited = new boolean[5][5];
                        System.out.println("");
                        System.out.println("(" + m + ", " + n + ") : 시작점");
                        bfs(m, n, 0, 0);
                        if(result){
                            System.out.println("cnt: " + cnt + " 자리안지켜서 0이야");
                            answer[cnt++] = 0;
                            break;
                        }
                    }
                }
                if(result) break;
            }
            System.out.println("result: " + result);
            System.out.println("--------------------");
            // default가 0이므로 1 꼭 넣어줘야 함
            if(!result) answer[cnt++] = 1;
        }
        
        return answer;
    }
}