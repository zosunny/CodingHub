import java.util.*;

/*
    개수 <= 100,000
    1. 순열, 백트래킹 -> n! 안됨
    2. 정렬 -> 두개를 문자열로 더한 값을 비교? -> n
*/

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        int n = numbers.length;
        
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(int i=0; i<n; i++){
            if(answer.equals("0")) answer = "";
            answer += arr[i];
        }
        
        return answer;
    }
}