import java.util.*;

class Solution {
    
    static int answer;
    static int ans;
    static boolean flag;
    static String[] alpa = {"A", "E", "I", "O", "U"};
    
    public static void dfs(String s, String word, int cnt){
        if(cnt == 5){
            if(s.equals(word)){
                answer = ans;
                flag = true;
            }
            return;
        }
        if(s.equals(word)){
            answer = ans;
            flag = true;
            return;
        }
        for(int i=0; i<5; i++){
            ans++;
            dfs(s+alpa[i], word, cnt+1);
            if(flag) return;
        }
    }
    
    public int solution(String word) {
        
        dfs("", word, 0);
        
        return answer;
    }
}