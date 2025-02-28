import java.util.*;

/*
    개수 <= 100,000
    1. 순열, 백트래킹 -> n! 안됨
    2. 정렬 -> 두개를 문자열로 더한 값을 비교? -> n
    
    *** 000 생각하자!!!!!!!
*/

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(int i=0; i<n; i++){
            if(answer.equals("0")) answer = "";
            answer += str[i];
        }
        
        return answer;
    }
}