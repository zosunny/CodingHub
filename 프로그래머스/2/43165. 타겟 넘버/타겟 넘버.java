import java.util.*;

class Solution {
    
    static int answer;
    static int len;
    
    public static int calc(boolean[] op, int[] numbers){
        int tmp = 0;
        for(int i=0; i<len; i++){
            // 연산자가 + 인 경우
            if(op[i]) tmp += numbers[i];
            // 연산자가 - 인 경우
            else tmp -= numbers[i];
        }
        return tmp;
    }
    
    public static void subset(int cnt, boolean[] select, int[] numbers, int target){
        if(cnt == len){
            if(calc(select, numbers) == target) answer++;
            return;
        }
        select[cnt] = true;
        subset(cnt+1, select, numbers, target);
        select[cnt] = false;
        subset(cnt+1, select, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        
        len = numbers.length;   // 숫자 개수
        
        boolean[] select = new boolean[len];
        subset(0, select, numbers, target);
        
        return answer;
    }
}