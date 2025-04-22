import java.util.*;

/*
    ()를 계속 찾아서 없앴을 때 남아 있는 게 있으면 false
    문자열 매번 복사 * 새로 생성 -> 최대 100,000 * 최대 100,000번 반복 -> O(100,000^2)
*/

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') st.push(c);
            else {
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        
        if(!st.isEmpty()) answer = false;
        
        return answer;
    }
}