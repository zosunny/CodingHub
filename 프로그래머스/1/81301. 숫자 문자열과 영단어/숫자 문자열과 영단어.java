import java.util.*;

class Solution {
    
    static String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public static String changeword(String s){
        while(true){
            boolean flag = false;
            for(int i=0; i<10; i++){
                if(s.contains(word[i])){
                    int idx = s.indexOf(word[i]);
                    String before = s.substring(0, idx);
                    String after = s.substring(idx+word[i].length());
                    s = before + Integer.toString(i) + after;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return s;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        // 문자 포함 여부 확인 및 변경
        answer = Integer.parseInt(changeword(s));
        
        return answer;
    }
}