import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int n = clothes.length;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for(int x : map.values()){
            answer *= x;
        }
        
        return answer-1;
    }
}