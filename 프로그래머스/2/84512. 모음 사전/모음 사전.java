import java.util.*;

class Solution {
    
    static int ans = 1;
    static int answer;
    static boolean flag;
    static String[] dict = {"A", "E", "I", "O", "U"};
    static List<String> list;
    
    public static void dfs(int cnt, String word, String tmp){
        if(cnt >= 5) return;
        for(int i=0; i<5; i++){
            String now = tmp+dict[i];
            if(now.equals(word)) {
                answer = ans;
                flag = true;
            }
            list.add(now);
            System.out.println(now + " " + ans);
            ans++;
            dfs(cnt+1, word, now);
            if(flag) return;
        }
    }
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        dfs(0, word, "");
        
        return answer;
    }
}