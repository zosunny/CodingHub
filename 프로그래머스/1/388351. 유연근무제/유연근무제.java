import java.util.*;

/*
  토, 일 은 이벤트 X
  시 * 100 + 분
  1 : 월요일
  
  1) schedules에 + 10분을 해서 마감 시간
  2) starday가 1이면 5, 6 제외 / 2면 4, 5제외 / 3이면 3, 4제외 -> 7-startday랑 6-startday 제외
  3) 마감시간안에 들어왔는지 체크
*/

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = timelogs.length;
        
        for(int i=0; i<n; i++){
            // 마감 시간 체크
            int limit = schedules[i] + 10;
            if(limit % 100 >= 60){
                int s = limit / 100 + 1;
                int m = (limit % 100) % 60;
                limit = s * 100 + m;
            }
            boolean flag = true;
            for(int j=0; j<7; j++){
                if(j == 7-startday || j == (6-startday + 7) % 7) continue;
                if(timelogs[i][j] > limit) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}