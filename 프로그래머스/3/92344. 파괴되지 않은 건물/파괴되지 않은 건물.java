import java.util.*;

/*
    1. 파괴와 복구에 대해 map에 누적합 만들기
    2. board에 map을 더해서 1 이상인지 확인
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int l = skill.length;
        
        int[][] map = new int[n+1][m+1];
        for(int i=0; i<l; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = type == 1 ? -skill[i][5] : skill[i][5];
            
            map[r1][c1] += degree;
            map[r2+1][c1] -= degree;
            map[r1][c2+1] -= degree;
            map[r2+1][c2+1] += degree;
        }
        
        // 위 -> 아래로 누적합 만들기
        for(int i=1; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                map[i][j] += map[i-1][j];
            }
        }
        
        // 왼 -> 오른으로 누적합 만들기
        for(int i=0; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                map[i][j] += map[i][j-1];
            }
        }
        
        // board에 map 반영해 파괴된 건물 수 확인
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] + map[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}