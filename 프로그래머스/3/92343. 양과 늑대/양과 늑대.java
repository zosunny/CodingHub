import java.util.*;

class Solution {
    
    static int ans;
    static List<Integer>[] list;
    
    public static void dfs(List<Integer> node, int sheep, int wolf, int[] info){
        ans = Math.max(ans, sheep);
        
        for(int i=0; i<node.size(); i++){
            int now = node.get(i);
            
            List<Integer> next = new ArrayList<>(node);
            
            if(info[now] == 0){
                next.remove(i);
                next.addAll(list[now]);
                dfs(next, sheep+1, wolf, info);
            }else if(wolf + 1 < sheep){
                next.remove(i);
                next.addAll(list[now]);
                dfs(next, sheep, wolf+1, info);
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        int n = info.length;
        
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        int m = edges.length;
        for(int[] e : edges){
            list[e[0]].add(e[1]);
        }
        
        List<Integer> node = new ArrayList<>();
        node.add(0);
        
        dfs(node, 0, 0, info);
        
        return ans;
    }
}