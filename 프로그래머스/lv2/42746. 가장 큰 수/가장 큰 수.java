import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 문자열 배열로 변환
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        // 6, 10 -> 610, 106 처럼 비교해 정렬
        Arrays.sort(arr, (o1, o2)->(o2+o1).compareTo(o1+o2));
        
        // 배열이 [0, 0, 0, ...] 인경우 "000..."이 아닌 "0"을 반환해야 함
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}