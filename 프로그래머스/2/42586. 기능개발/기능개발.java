import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<len; i++){
            int days = (int)Math.ceil((float)(100 - progresses[i]) / (float)speeds[i]);
            q.add(days);
        }
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            int fp = q.poll();
            int cnt = 1;
            while(!q.isEmpty()){
                int p = q.peek();
                if(p <= fp){
                    cnt++;
                    q.poll();
                }else break;
            }
            s.add(cnt);
        }
        int sSize = s.size();
        answer = new int[sSize];
        for(int i=sSize-1; i>=0; i--){
            answer[i] = s.pop();
        }
        return answer;
    }
}