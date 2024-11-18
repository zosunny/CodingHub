import java.util.*;

class Solution {
    
    static int answer;
    static int len;
    static boolean[] select;
    
    // 순서대로 탐험했을 때 탐험 가능한 던전 수 계산하는 메서드
    public static void calc(int[] input, int k, int[][] dungeons){
        int cnt = 0;
        for(int i=0; i<len; i++){
            int d = input[i];
            // 현재 피로도보다 최소 필요 피로도가 작아야 함
            if(k < dungeons[d][0]) continue;
            k -= dungeons[d][1];
            cnt++;
        }
        answer = Math.max(answer, cnt);
    }
    
    // 탐험할 던전의 순서 정하는 메서드
    public static void permu(int cnt, int[] input, int k, int[][] dungeons){
        if(cnt == len){
            calc(input, k, dungeons);
            return;
        }
        for(int i=0; i<len; i++){
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            permu(cnt+1, input, k, dungeons);
            select[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        len = dungeons.length;
        int[] input = new int[len];
        select = new boolean[len];
        permu(0, input, k, dungeons);
        
        return answer;
    }
}