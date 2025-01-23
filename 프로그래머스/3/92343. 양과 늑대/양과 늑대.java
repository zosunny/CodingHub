import java.util.*;

class Solution {
    
    static int len;
    static int maxAns;
    static List<Integer>[] list;
    
    public static void dfs(int sheep, int wolf, List<Integer> node, int[] info){
        
        maxAns = Math.max(maxAns, sheep);
            
        for(int i=0; i<node.size(); i++){
            int x = node.get(i);
            // System.out.println("노드: " + x);
            
            // 다음 탐색 가능한 노드들 - 자식 노드
            List<Integer> next = new ArrayList<>(node);
            next.remove(i);             // 현 노드는 제거
            next.addAll(list[x]);       // 현 노드의 자식 노드 추가
            
            if(info[x] == 0) {
                System.out.println("sheep: " + (sheep+1) + ", wolf: " + wolf);
                dfs(sheep+1, wolf, next, info);            // 양
            }
            else if(sheep > wolf + 1) {
                System.out.println("sheep: " + sheep + ", wolf: " + (wolf+1));
                dfs(sheep, wolf+1, next, info);   // 늑대면서 양보다 적을 때
            }
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {
        
        len = info.length;
        
        list = new ArrayList[len];
        for(int i=0; i<len; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            list[edge[0]].add(edge[1]);
        }
        
        // 초기 탐색 가능한 노드
        List<Integer> node = new ArrayList<>();
        node.add(0);
        
        dfs(0, 0, node, info);
        
        return maxAns;
    }
}