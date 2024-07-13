import java.util.*;

class Solution {
    
    static int len;
    static int answer = Integer.MIN_VALUE;
    
    public static void calc(int k, int[] input, int[][] dungeons){
        int cnt = 0;
        // 순열의 순서대로 피로도 계산
        for(int i=0; i<len; i++){
            int now = input[i];
            int start = dungeons[now][0];
            int use = dungeons[now][1];
            if(k < start) continue;
            k -= use;
            cnt++;
        }
        answer = Math.max(answer, cnt);
    }
    
    public static void permu(int cnt, int[] input, boolean[] select, int k, int[][] dungeons){
        if(cnt == len){
            calc(k, input, dungeons);
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
        
        return answer;
    }
}