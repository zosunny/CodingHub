import java.util.*;

/*
    가장 짧은 변환 과정 -> bfs
    변환할 수 없는 경우 0
    
    1. 배열돌면서 현재 단어랑 비교
    2. 방문전이고, 알파벳 1개만 다를 경우 큐에 넣기
    
*/

class Solution {
    
    static class Point{
        String str;
        int cnt;
        Point(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    static int n;
    static int len;
    static int ans = Integer.MAX_VALUE;
    
    public static void bfs(String begin, String target, String[] words){
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new Point(begin, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.str.equals(target)){
                ans = Math.min(ans, p.cnt);
            }
            for(int i=0; i<n; i++){
                if(visited[i]) continue;
                // 알파벳 비교
                int tmp = 0;
                for(int j=0; j<len; j++){
                    if(p.str.charAt(j) != words[i].charAt(j)) tmp++;
                }
                // 1개만 다르면
                if(tmp == 1){
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