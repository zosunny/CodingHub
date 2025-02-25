import java.util.*;

class Solution {
    
    static int n;
    static int ans;
    static List<Integer>[] list;
    
    public static void dfs(List<Integer> node, int sheep, int wolf, int[] info){
        ans = Math.max(ans, sheep);
        
        for(int i=0; i<node.size(); i++){
            
            int n = node.get(i);
            
            // 다음 탐색 노드 생성
            List<Integer> next = new ArrayList<>(node);
            
            // 현재 노드가 양이면
            if(info[n] == 0){
                next.remove(i);         // 다음 탐색할 때 제거
                next.addAll(list[n]);   // 탐색 리스트에 자식 노드 추가
                dfs(next, sheep+1, wolf, info);
            }
            // 늑대지만 양의 수보다 적으면
            else if(wolf + 1 < sheep){
                next.remove(i);         // 다음 탐색할 때 제거
                next.addAll(list[n]);   // 탐색 리스트에 자식 노드 추가
                dfs(next, sheep, wolf+1, info);
            }
            // 그외(늑대 수가 양보다 크거나 같은 경우) 다음 노드 탐색
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        
        n = info.length;
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            list[e[0]].add(e[1]);
        }
        
        // 탐색할 노드만 담는 새로운 리스트 생성
        List<Integer> node = new ArrayList<>();
        node.add(0);
        
        dfs(node, 0, 0, info);
        
        return ans;
    }
}