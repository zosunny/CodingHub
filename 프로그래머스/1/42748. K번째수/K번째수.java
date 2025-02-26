import java.util.*;

/*
    array를 commands 기준에 따라 탐색 -> 100 * 50
*/

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int n = commands.length;
        
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int s = commands[i][0] - 1;
            int e = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] tmp = new int[e-s+1];
            int idx = 0;
            for(int j=s; j<e+1; j++){
                tmp[idx++] = array[j];
            }
            
            Arrays.sort(tmp);
            ans[i] = tmp[k];
        }
        return ans;
    }
}