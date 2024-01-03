import java.util.*;

class Solution {
    
    class Point{
        int num;
        int ans;
        int idx;
        Point(int num, int ans, int idx){
            this.num = num;
            this.ans = ans;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<Point> s = new Stack<>();
        Stack<Point> tmp = new Stack<>();
        s.push(new Point(prices[0], len-1, 0));
        answer[0] = len-1;
        for(int i=1; i<len; i++){
            int nowNum = prices[i];
            int nowAns = len-i-1;
            // now가 이전 값보다 작으면
            if(nowNum < prices[i-1]){
                // now보다 크면서 check점이 찍힌 곳 전까지 확인
                while(!s.isEmpty()){
                    if(s.peek().num <= nowNum) break;
                    Point p = s.pop();
                    if(p.ans == len-p.idx-1){
                        tmp.push(new Point(p.num, p.ans-nowAns, p.idx));
                        answer[p.idx] = p.ans-nowAns;
                    }
                }
            }
            // 현재 값
            s.push(new Point(nowNum, nowAns, i));
            answer[i] = nowAns;
        }
        
        return answer;
    }
}