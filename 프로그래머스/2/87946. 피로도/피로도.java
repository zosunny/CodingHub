import java.util.*;

/*
탐험할 수 있는 최대 던전 수

1. 순열
2. 탐색(max값)
-> 8!
*/

class Solution {
    
    static int len;
    static int ans;
    
    public static void calc(int[] input, int k, int[][] dungeons){
        int tmp = 0;
        for(int i=0; i<len; i++){
            // 현재 피로도 < 최소 필요 피로도
            if(k < dungeons[input[i]][0]) break;
            k -= dungeons[input[i]][1];
            tmp++;
        }
        ans = Math.max(ans, tmp);
    }
    
    public static void permu(int cnt, int[] input, boolean[] select, int k, int[][] dungeons){
        if(cnt == len){
            calc(input, k, dungeons);
            return;
        }
        for(int i=0; i<len; i++){
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            permu(cnt+1, input, select, k, dungeons);
            select[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        
        int[] input = new int[len];
        boolean[] select = new boolean[len];
        permu(0, input, select, k, dungeons);
        
        return ans;
    }
}