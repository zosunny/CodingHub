import java.util.*;

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
        
        // 위 -> 아래
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                map[i][j] += map[i-1][j];
            }
        }
        
        // 왼 -> 오른
        for(int i=0; i<=n; i++){
            for(int j=1; j<=m; j++){
                map[i][j] += map[i][j-1];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += map[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}