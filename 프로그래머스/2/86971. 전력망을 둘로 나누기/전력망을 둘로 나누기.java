import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int len;
    static boolean[] select;
    static boolean[] visited;
    static List<Integer>[] list;
    
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            dfs(now);
        }
    }
    
    public static void combi(int cnt, int start, int n, int[][] wires){
        if(cnt == 1){
            // 인접리스트 생성
            list = new ArrayList[n+1];
            for(int i=0; i<n+1; i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<len; i++){
                if(select[i]) {
                    System.out.println(wires[i][0] + ", " + wires[i][1] + " 끊음");
                    continue;
                }
                int x = wires[i][0];
                int y = wires[i][1];
                list[x].add(y);
                list[y].add(x);
            }
            for(int i=0; i<n+1; i++){
                System.out.print("[" + i + "]: ");
                for(int j=0; j<list[i].size(); j++){
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
            visited = new boolean[n+1];
            dfs(1);
            int ans = 0;
            for(boolean x : visited) {
                System.out.print(x + " ");
                if(x) {
                    ans++;
                }
            }
            System.out.println();
            answer = Math.min(answer, Math.abs(n - 2*ans));
            System.out.println("차이: " + Math.abs(n - ans));
            System.out.println("---------------");
            return;
        }
        for(int i=start; i<len; i++){
            if(select[i]) continue;
            select[i] = true;
            combi(cnt+1, i+1, n, wires);
            select[i] = false;
        }
    }
    
    public int solution(int n, int[][] wires) {
        
        len = wires.length;
        
        select = new boolean[len];
        combi(0, 0, n, wires);
        
        return answer;
    }
}