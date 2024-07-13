import java.util.*;

class Solution {
    
    static int len;
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt;
    static int answer = Integer.MAX_VALUE;
    
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(!visited[now]) {
                dfs(now);
                cnt++;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        len = wires.length;
        
        for(int i=0; i<len; i++){
            list = new ArrayList[n+1];
            for(int j=0; j<n+1; j++){
                list[j] = new ArrayList<>();
            }
            // 하나씩 끊어서 연결해보기
            int a = 0;
            for(int j=0; j<len; j++){
                if(i == j) continue;
                int x = wires[j][0];
                int y = wires[j][1];
                list[x].add(y);
                list[y].add(x);
                a = x;
            }
            // 해당 전력망으로 송전탑 차 구하기
            visited = new boolean[n+1];
            cnt = 1;
            dfs(a);
            answer = Math.min(answer, Math.abs(2*cnt - n));
        }
        
        return answer;
    }
}