import java.util.*;

class Solution {
    
    static class Point{
        char alpha;
        int num;
        Point(char alpha, int num){
            this.alpha = alpha;
            this.num = num;
        }
    }
    
    static int answer;
    static int maxNum = Integer.MIN_VALUE;
    static Queue<Point> q;
    static char[] result;
    
    // 실행 대기 큐에서 큰 수 찾는 함수
    public static void calc(){
        int qSize = q.size();
        while(qSize --> 0){
            Point p = q.poll();
            maxNum = Math.max(maxNum, p.num);
            q.add(p);
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        q = new LinkedList<>();
        int len = priorities.length;
        for(int i=0; i<len; i++){
            q.add(new Point((char)('A'+i), priorities[i]));
            maxNum = Math.max(maxNum, priorities[i]);
        }
        
        result = new char[len];
        int idx = 0;
        while(!q.isEmpty()){
            Point now = q.poll();
            // 우선순위가 낮은 프로세스인 경우
            if(now.num < maxNum){
                q.add(now);
            }
            // 우선순위가 같거나 큰 프로세스인 경우
            else if(now.num >= maxNum){
                result[idx++] = now.alpha;
                maxNum = Integer.MIN_VALUE;
                calc();
            }
        }
        for(int i=0; i<len; i++){
            if(result[i] == (char)(location + 'A')){
                answer = i + 1;
            }
        }
        return answer;
    }
}