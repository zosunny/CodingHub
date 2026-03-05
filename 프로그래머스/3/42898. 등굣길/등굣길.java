import java.util.*;

/*
    n*m
    오른쪽, 아래쪽 이동
    ** 최단경로 개수 % 1000000007
    ** 나머지를 저장하기
    
    오른쪽으로 누적합, 아래로 누적합
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        int[][] dp = new int[n+1][m+1];
        
        // 물웅덩이
        for(int[] x : puddles){
            dp[x[1]][x[0]] = -1;
        }
        
        // 누적합
        dp[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // 물웅덩이 만나면
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 1 && j == 1) continue;
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        
        return dp[n][m];
    }
}