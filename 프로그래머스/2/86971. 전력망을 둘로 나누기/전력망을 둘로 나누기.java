import java.util.*;

class Solution {
    
    static int cnt = 1;
    static List<Integer>[] list;
    static boolean[] visited;
    
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            visited[now] = true;
            cnt++;
            dfs(now);
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int k=0; k<n-1; k++){
            list = new ArrayList[n+1];
            for(int i=0; i<n+1; i++){
                list[i] = new ArrayList<>();
            }
            visited = new boolean[n+1];
            cnt = 1;
            for(int i=0; i<n-1; i++){
                int x = wires[i][0];
                int y = wires[i][1];
                if(k == i) continue;    // 전력망 1개 끊음
                list[x].add(y);
                list[y].add(x);
            }
            dfs(1);
            System.out.println();
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        
        return answer;
    }
}