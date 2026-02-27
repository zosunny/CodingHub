import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c =='(') st.push(c);
            else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        
        if(!st.isEmpty()) return false;

        return answer;
    }
}