import java.util.*;

/*
    -, + 순열 -> 최대 2^20
*/

class Solution {
    
    static int n;
    static int ans;
    
    public static int dfs(int cnt, int sum, int[] numbers, int target){
        if(cnt == n){
            return sum == target ? ans+1 : ans;
        }
        return dfs(cnt+1, sum+numbers[cnt], numbers, target)
            + dfs(cnt+1, sum-numbers[cnt], numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        
        ans = dfs(0, 0, numbers, target);
        
        return ans;
    }
}