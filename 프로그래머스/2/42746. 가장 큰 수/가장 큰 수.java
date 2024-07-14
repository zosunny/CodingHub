import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] str = new String[len];
        
        // 주어진 배열을 문자열로 변환
        for(int i=0; i<len; i++){
            str[i] = Integer.toString(numbers[i]);
        }
        // 내림차순 정렬
        Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        // 정수 이어붙이기
        for(int i=0; i<len; i++){
            // 만약 앞이 쭉 0이면
            if(answer.equals("0")) answer = "";
            answer += str[i];
        }
        
        return answer;
    }
}