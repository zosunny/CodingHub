import java.util.*;

class Solution {
    public int solution(String arr[]) {
        
        int n = (arr.length / 2) + 1;
        
        int[][] max_dp = new int[n][n];
        int[][] min_dp = new int[n][n];
        
        // 숫자 1개인 경우
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(arr[i*2]);
            max_dp[i][i] = num;
            min_dp[i][i] = num;
        }
        
        // 구간을 늘려가며 계산
        for(int step=1; step<n; step++){
            for(int i=0; i<n-step; i++){
                
                int j = i + step;
                
                // 초기값
                max_dp[i][j] = Integer.MIN_VALUE;
                min_dp[i][j] = Integer.MAX_VALUE;
                
                // i와 j사이를 k번째 연산자를 기준으로 쪼개기
                for(int k=i; k<j; k++){
                    String op = arr[k*2+1];
                    
                    if(op.equals("+")){
                        // + : max = (max + max), min = (min + min)
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                    }else{
                        // - : max = (max - min), min = (min - max)
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }
        
        return max_dp[0][n-1];
    }
}