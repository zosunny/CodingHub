import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        int len = strings.length;
        
//         String[] answer = new int[len];
//         for(int i=0; i<len; i++){
//             strings[i].
//         }
        
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) - o2.charAt(n));
        
        String[] answer = new String[len];
        for(int i=0; i<len; i++){
            answer[i] = strings[i];
        }
        
        return answer;
    }
}