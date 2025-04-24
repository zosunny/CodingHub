import java.util.*;

/*
    1번 노드에서 가장 멀리 떨어진 노드 개수
    
    1. bfs로 최단거리 계산
    2. {거리 : 노드} 로 맵에 저장
*/

class Solution {
    
    static List<Integer>[] list;
    static Map<Integer, List<Integer>> map;
    
    public static void bfs(int x, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(x);
        visited[x] = true;
        int dis = 1;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                int p = q.poll();
                for(int i=0; i<list[p].size(); i++){
                    int nx = list[p].get(i);
                    if(visited[nx]) continue;
                    q.add(nx);
                    visited[nx] = true;
                    map.get(dis).add(nx);
                }
            }
            dis++;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int len = edge.length;
        
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<len; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            list[x].add(y);
            list[y].add(x);
        }
        
        map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        
        bfs(1, n);
        
        int dis = 0;
        for(int x : map.keySet()){
            for(int y : map.get(x)){
                if(x > dis){
                    dis = x;
                    answer = 1;
                }else answer++;
            }
        }
        
        return answer;
    }
}