import java.util.*;

/*
    오름차순 정렬, dfs
*/

class Solution {
    
    static Map<String, PriorityQueue<String>> map;
    static List<String> ans;
    
    public static void dfs(String now){
        // 현재 방문 도시(출발지)
        PriorityQueue<String> pq = map.get(now);
        // 방문 가능한 도시 방문
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        // 역순으로 저장
        ans.add(0, now);
    }
    
    public String[] solution(String[][] tickets) {
        
        int n = tickets.length;
        int m = tickets[0].length;
        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }
        
        map = new HashMap<>();
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        // ICN 공항에서 출발
        ans = new ArrayList<>();
        dfs("ICN");
        
        String[] answer = ans.toArray(new String[0]);
        
        return answer;
    }
}