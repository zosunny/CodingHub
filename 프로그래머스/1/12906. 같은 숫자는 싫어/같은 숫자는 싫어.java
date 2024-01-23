import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int len = arr.length;
        int[] answer = {};
        
        Stack<Integer> s = new Stack<>();
        for(int i=len-1; i>=0; i--){
            if(!s.isEmpty() && s.peek() == arr[i]) continue;
            s.push(arr[i]);
        }
        
        int cnt = 0;
        answer = new int[s.size()];
        while(!s.isEmpty()){
            answer[cnt++] = s.pop();
        }
        
        return answer;
    }
}