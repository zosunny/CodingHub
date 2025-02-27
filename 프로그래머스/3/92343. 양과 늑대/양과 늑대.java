import java.util.*;

/*
    1. 양일 때, 늑대여도 양보다 적을 때만 dfs 타면서 양의 최댓값 갱신
    2. 탐색을 모든 노드에 대해 하는 것이 아닌 현재 노드에서 갈 수 있는 자식 노드 까지만으로 한정
    3. 양일 때와 늑대여도 양보다 적었던 노드는 다시 탐색하지 않아도 됨. 이를 제외한 노드들만 다음 탐색에 이용
*/

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
        int m = edges.length;
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++){
            list[edges[i][0]].add(edges[i][1]);
        }
        
        List<Integer> node = new ArrayList<>();
        node.add(0);
        
        dfs(node, 0, 0, info);
        
        return ans;
    }
}