import java.util.*;

class Solution {
    
    static int answer;
    static List<Integer>[] list;
    static boolean[] visited;
    
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            dfs(now);
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1) list[i].add(j);
            }
        }
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            dfs(i);
            answer++;
        }
        
        return answer;
    }
}