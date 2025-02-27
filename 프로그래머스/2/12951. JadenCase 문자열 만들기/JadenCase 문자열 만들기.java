import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int n = s.length();
        
        answer += Character.toString(s.charAt(0)).toUpperCase();
        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == ' ') answer += Character.toString(s.charAt(i)).toUpperCase();
            else answer += Character.toString(s.charAt(i)).toLowerCase();
        }   
        return answer;
    }
}