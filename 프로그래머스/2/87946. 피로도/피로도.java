import java.util.*;

class Solution {
    
    static int answer = Integer.MIN_VALUE;
    static int len;
    static int[] input;
    static boolean[] select;
    
    public static void calc(int k, int[][] dungeons){
        int tmp = 0;
        for(int i=0; i<len; i++){
            if(dungeons[input[i]][0] > k) continue;
            k -= dungeons[input[i]][1];
            tmp++;
        }
        answer = Math.max(answer, tmp);
    }
    
    public static void permu(int cnt, int k, int[][] dungeons){
        if(cnt == len){
            calc(k, dungeons);
            return;
        }
        for(int i=0; i<len; i++){
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            permu(cnt+1, k, dungeons);
            select[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        len = dungeons.length;
        
        input = new int[len];
        select = new boolean[len];
        permu(0, k, dungeons);
        
        return answer;
    }
}