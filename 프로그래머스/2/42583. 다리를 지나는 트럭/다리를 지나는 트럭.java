import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.add(0);
        }
        
        int idx = 0;
        int total_weight = 0;
        while(idx < n){
            total_weight -= q.poll();
            answer++;
            // 다음 트럭 올릴 수 있는 경우
            if(total_weight + truck_weights[idx] <= weight){
                q.add(truck_weights[idx]);
                total_weight += truck_weights[idx];
                idx++;
            // 없는 경우
            }else{
                q.add(0);
            }
        }
        
        answer += q.size();
        return answer;
    }
}