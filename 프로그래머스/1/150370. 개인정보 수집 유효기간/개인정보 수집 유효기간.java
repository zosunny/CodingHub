import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        int flag = (year * 12 * 28) + (month * 28) + day;
        
        // 유효기간
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        // 개인정보 수집 만료일 확인
        for(int i=0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            int y = Integer.parseInt(date.split("\\.")[0]);
            int m = Integer.parseInt(date.split("\\.")[1]);
            int d = Integer.parseInt(date.split("\\.")[2]);
            String type = privacies[i].split(" ")[1];
            
            int sum = (y * 12 * 28) + (m * 28) + d + (Integer.parseInt(map.get(type)) * 28);
            if(flag >= sum) pq.add(i+1);
        }
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}