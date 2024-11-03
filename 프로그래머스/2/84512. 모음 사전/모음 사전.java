class Solution {
    
    static int ans;
    static int answer;
    static String[] arr = {"A", "E", "I", "O", "U"};
    
    public static void dfs(String now, int cnt, int start, String word){
        if(cnt == 5) {
            if(now.equals(word)){
            answer = ans;
            }
            return;
        }
        if(now.equals(word)){
            answer = ans;
            return;
        }
        for(int i=start; i<5; i++){
            ++ans;
            dfs(now+arr[i], cnt+1, start, word);
        }
    }
    
    public int solution(String word) {
        
        dfs("", 0, 0, word);
        
        return answer;
    }
}