import java.util.*;

class Solution {
    
    static int N, M;
    static int sum;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        sum += arr[x][y] - '0';
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(arr[nx][ny]!='X' && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
    
    public ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        
        // 2차원 배열에 옮기기
        arr = new char[N][M];
        for(int i=0; i<N; i++){
            arr[i] = maps[i].toCharArray();
        }
        // 무인도 찾기
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 'X' && !visited[i][j]){
                    sum = 0;
                    dfs(i, j);
                    answer.add(sum);
                }
            }
        }
        // 리스트 정렬
        Collections.sort(answer);
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        return answer;
    }
}