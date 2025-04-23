import java.util.*;

class Solution {
    
    static int n;
    static int answer;
    
    public static void calc(int[] input, int[] numbers, int target){
        int tmp = 0;
        for(int i=0; i<n; i++){
            if(input[i] == 0){
                tmp += numbers[i];
            }else{
                tmp -= numbers[i];
            }
        }
        if(tmp == target) answer++;
    }
    
    public static void permu(int cnt, int[] input, int[] numbers, int target){
        if(cnt == n){
            calc(input, numbers, target);
            return;
        }
        for(int i=0; i<2; i++){
            input[cnt] = i;
            permu(cnt+1, input, numbers, target);
        }
    }
    
    public int solution(int[] numbers, int target) {
        
        n = numbers.length;
        
        int[] input = new int[n];
        permu(0, input, numbers, target);
        
        return answer;
    }
}