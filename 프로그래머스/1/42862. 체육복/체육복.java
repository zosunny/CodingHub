import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        int [] have = new int[n];
        boolean[] check = new boolean[n];
        Arrays.fill(have, 1);
        // 잃어버린 경우
        for(int i=0; i<lost.length; i++){
            have[lost[i]-1] = 0;
        }
        // 나눠줄 수 있는 경우 - 1. 내꺼 확인
        for(int i=0; i<reserve.length; i++){
            int now = reserve[i];
            // 잃어버린 학생였음 T로 변경 먼저 수행
            if(have[now-1]==0) {
                have[now-1] = 1;
                check[now-1] = true;
            }
        }
        // 나눠줄 수 있는 경우 - 2. 앞 뒤 확인
        for(int i=0; i<reserve.length; i++){
            int now = reserve[i];
            if(check[now-1]) continue;
            System.out.println("체육복 있는 학생: " + now);
            // 그외 앞 뒤 확인
                // 앞 학생 없는 경우
                if((now-2)>=0 && have[now-2]==0) {
                    have[now-2] = 1;
                    System.out.println((now) + "이 " + (now-1) + "한테 빌려줌");
                    continue;
                // 뒤 학생 없는 경우
                }else if(now<n && have[now]==0){
                    have[now] = 1;
                    System.out.println((now) + "이 " + (now+1) + "한테 빌려줌");
                    continue;
                }
        }
        // 학생 수 계산
        for(int x : have){
            System.out.print(x + " ");
            if(x==1) answer++;
        }
        return answer;
    }
}