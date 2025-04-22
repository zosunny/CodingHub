import java.util.*;

/*
    모든 음식의 스코빌 지수 K 이상 될 때까지
    섞어야 하는 최소 횟수
    음식 개수 <= 1,000,000
    K <= 1,000,000,000
    
    우선순위큐
*/

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n = scoville.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            int x = pq.poll();
            if(x >= K) break;
            if(pq.isEmpty()) return -1;
            int y = pq.poll();
            pq.add(x + y * 2);
            answer++;
        }
        
        return answer;
    }
}