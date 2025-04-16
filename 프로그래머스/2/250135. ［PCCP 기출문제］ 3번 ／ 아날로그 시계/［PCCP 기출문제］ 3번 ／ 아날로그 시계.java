import java.util.*;

/*
    초침이 시침/분침과 겹칠 때마다 알람
    특정 시간 동안 알람이 울린 횟수
    
    둘 다 겹치면 한번 울림
    
    초침 : 1초에 6도
    분침 : 1분에 6도 + 1초에 0.1도
    시침 : 1시간에 30도 + 1분에 0.5도 + 1초에 0.5/60도
*/

class Solution {
    
    // 현 시각까지 몇번 겹치는 지
    public static int calc(int time){
        int sm = time * 59 / 3600;
        int sh = time * 719 / 43200;
        int a = time >= 43200 ? 2 : 1;
        
        return (sm + sh) - a;
    }
    
    // 현재 정확히 겹치는 순간인지
    public static int now(int time){
        if(time * 59 % 3600 == 0 || time * 719 % 43200 == 0) return 1;
        else return 0;
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        return calc(end) - calc(start) + now(start);
    }
}