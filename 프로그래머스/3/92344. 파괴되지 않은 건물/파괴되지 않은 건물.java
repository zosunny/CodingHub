import java.util.*;

/*
    입력
        board : 내구도 (최대 1,000 * 1,000 = 1,000,000)
        skill : 적군, 아군 스킬 (최대 250,000)
        [아군 또는 적군 타입, x1, y1, x2, y2, 크기], [], ...
    출력
        파괴되지 않은 건물 개수 (1 이상)
    로직
        그냥 구현 -> 250,000,000,000
        누적합 -> 1,000,000 + 250,000 -> 최대 1,000,000
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int l = skill.length;
        
        int[][] map = new int[n+1][m+1];
        // 누적 합
        for(int i=0; i<l; i++){
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][0] == 1 ? -skill[i][5] : skill[i][5];
            
            map[r1][c1] += degree;
            map[r1][c2+1] -= degree;
            map[r2+1][c1] -= degree;
            map[r2+1][c2+1] += degree;
        }
        
        // 위 -> 아래 계산
        for(int i=1; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                map[i][j] += map[i-1][j];
            }
        }
        
        // 왼 -> 오 계산
        for(int i=0; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                map[i][j] += map[i][j-1];
            }
        }
        
        // 1 이상인 경우
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += map[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}