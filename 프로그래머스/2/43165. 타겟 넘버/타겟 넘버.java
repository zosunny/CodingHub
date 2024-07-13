import java.util.*;

class Solution {
    
    static int answer;
    static int len;
    static boolean[] select;
    
    public static void calc(int[] numbers, int target){
        int ans = 0;
        for(int i=0; i<len; i++){
            if(select[i]) ans += numbers[i];
            else ans -= numbers[i];
        }
        // 타겟넘버가 맞으면
        if(ans == target) answer++;
    }
    
    public static void subset(int cnt, int[] numbers, int target){
        if(cnt == len){
            calc(numbers, target);
            return;
        }
        select[cnt] = true;
        subset(cnt+1, numbers, target);
        select[cnt] = false;
        subset(cnt+1, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        
        len = numbers.length;
        select = new boolean[len];
        subset(0, numbers, target);
        
        return answer;
    }
}