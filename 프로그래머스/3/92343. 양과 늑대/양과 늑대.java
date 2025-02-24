import java.util.*;

class Solution {
    
    static int n;
    static int answer;
    static List<Integer>[] list;
    
    public static void dfs(List<Integer> node, int sheep, int wolf, int[] info){
        
        // 양의 수 최댓값 갱신
        answer = Math.max(answer, sheep);
        
        for(int i=0; i<node.size(); i++){
            int n = node.get(i);
            
            List<Integer> next = new ArrayList<>(node);
            
            if(info[n]  == 0){          // 양인 경우
                next.remove(i);         // 자기자신 삭제
                next.addAll(list[n]);   // 자식노드 추가
                dfs(next, sheep+1, wolf, info);
            }else if(wolf + 1 < sheep){     // 늑대면서 양보다 수가 적은 경우
                next.remove(i);
                next.addAll(list[n]);
                dfs(next, sheep, wolf+1, info);
            }
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
        
        List<Integer> node = new ArrayList<>();
        node.add(0);
        dfs(node, 0, 0, info);
        
        return answer;
    }
}