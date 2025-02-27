import java.util.*;

class Solution {
    
    static int ans;
    static List<Integer>[] list;
    
    public static void dfs(List<Integer> node, int sheep, int wolf, int[] info){
        ans = Math.max(ans, sheep);
        
        for(int i=0; i<node.size(); i++){
            
            List<Integer> next = new ArrayList<>(node);     // for문 안에서 생성해서 dfs 경로에서 독립적으로 사용되게 해야함
            
            int now = node.get(i);
            // 만약 현재 노드가 양이면
            if(info[now] == 0){
                next.remove(i);             // 탐색할 노드에서 현재 노드는 지우고
                next.addAll(list[now]);     // 현 노드의 자식노드 모두 탐색 노드에 넣고
                dfs(next, sheep+1, wolf, info);
            }
            // 현재 노드가 늑대지만 양의 수보다 적으면
            else if(wolf + 1 < sheep){
                next.remove(i);
                next.addAll(list[now]);
                dfs(next, sheep, wolf+1, info);
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        int n = info.length;
        int m = edges.length;
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++){
            list[edges[i][0]].add(edges[i][1]);
        }
        
        // 탐색할 노드를 담는 리스트 생성
        List<Integer> node = new ArrayList<>();
        node.add(0);
        
        dfs(node, 0, 0, info);
        
        return ans;
    }
}