import java.util.*;

/*
    가장 짧은 변환 과정
    words에서 변환 가능한 단어, 변환 과정 수 q에 저장
*/

class Solution {
    
    static int n;
    static int len;
    static int ans = Integer.MAX_VALUE;
    
    static class Point{
        String word;
        int cnt;
        Point(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public static void bfs(String begin, String target, String[] words){
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new Point(begin, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.word.equals(target)){
                ans = Math.min(ans, p.cnt);
            }
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                int num = 0;
                for(int j=0; j<len; j++){
                    if(p.word.charAt(j) != words[i].charAt(j)) num++;
                }
                if(num == 1){
                    q.add(new Point(words[i], p.cnt+1));
                    visited[i] = true;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        len = begin.length();
        
        bfs(begin, target, words);
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}