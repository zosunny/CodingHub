import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        int[] tmp = {};
        
        int num = 0;
        for(int n=0; n<len; n++){
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            tmp = new int[j-i+1];
            int idx = 0;
            for(int m=i-1; m<j; m++){
                tmp[idx++] = array[m];
            }
            Arrays.sort(tmp);
            answer[num++] = tmp[k-1];
        }
        
        return answer;
    }
}