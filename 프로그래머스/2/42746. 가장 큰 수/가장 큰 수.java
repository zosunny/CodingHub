import java.util.*;

/*
    1. 순열 -> 100,000! X
    2. 비교정렬 -> nlogn?
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
            answer += arr[i];
            if(answer.equals("00")) answer = "0";
        }
        
        return answer;
    }
}