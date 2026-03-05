import java.util.*;

/*
    거쳐간 숫자의 최댓값
    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])
*/

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        if(n == 1) return triangle[0][0];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else {
                    triangle[i][j] = Math.max(triangle[i-1][j], triangle[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        for(int j=0; j<triangle[n-1].length; j++){
            answer = Math.max(answer, triangle[n-1][j]);
        }
        
        return answer;
    }
}