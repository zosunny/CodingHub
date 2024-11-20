import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int cnt = 1;
    static boolean[] visited;
    static List<Integer>[] list;
    
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            cnt++;
            dfs(now);
        }
    }
    
    public int solution(int n, int[][] wires) {
        int len = wires.length;
        
        for(int i=0; i<len; i++){
            list = new ArrayList[n+1];
            for(int k=0; k<n+1; k++){
                list[k] = new ArrayList<>();
            }
            cnt = 1;
            for(int j=0; j<len; j++){
                if(i == j) continue;
                int x = wires[j][0];
                int y = wires[j][1];
                list[x].add(y);
                list[y].add(x);
            }
            visited = new boolean[n+1];
            dfs(1);
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        return answer;
    }
}