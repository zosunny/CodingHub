import java.util.*;

/*
    N 다음은 1
    1초 섭취한 후, 남은 음식 그대로, 다음 음식 섭취
    K초 후에 방송 중단, 방송 시작할 때 섭취하는 음식 몇번?
    
입력
    food_times : 각 음식 소요 시간  / N <= 2,000 / 시간 <= 1,000
    k : 네트워크 장애 발생 시간 <= 2,000,000
    
    1. 정확성 => 큐 -> 2,000,000
    2. 효율성 => 큐 -> 2 * 10^13 -> X
        1. 우선순위 큐 -> nlogn, 그리디
    
출력
    더 섭취할 음식 없으면 -1 반환
*/


class Solution {
    
    static class Point{
        int idx;
        int time;
        Point(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
    
    static int answer = -1;
    
    public int solution(int[] food_times, long k) {
        
        int n = food_times.length;
        
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        for(int i=0; i<n; i++){
            pq.add(new Point(i+1, food_times[i]));
        }
        
        long total_time = 0;
        long prev_time = 0;
        long food_cnt = n;
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            long cycle_time = (p.time - prev_time) * food_cnt;
            
            if(total_time + cycle_time > k){
                pq.add(p);
                break;
            }
            
            total_time += cycle_time;
            prev_time = p.time;
            food_cnt--;
        }
        
        List<Point> list = new ArrayList<>(pq);
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.idx, o2.idx));
        
        if(!list.isEmpty()) answer = list.get((int)((k - total_time) % food_cnt)).idx;
        
        return answer;
    }
}