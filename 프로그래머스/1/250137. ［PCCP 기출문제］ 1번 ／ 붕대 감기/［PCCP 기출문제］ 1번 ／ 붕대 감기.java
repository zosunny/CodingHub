import java.util.*;

/*
    t초 붕대 1초마다 x체력 회복
    t초 연속 붕대 -> y만큼 체력 추가 회복
    현재 체력 <= 최대 체력 유지
    
    몬스터 공격 -> 기술 취소, 체력 회복 불가 -> 즉시 붕대 감기, 연속 성공 시간 0 초기화
    몬스터 공격 -> 정해진 피해량 만큼 현재 체력 감소 -> 체력 <= 0 이면, 죽음
    
    남은 체력 반환
*/

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int ans = health;
        int len = attacks[attacks.length-1][0];
        int cnt = 0;
        int idx = 0;
        
        for(int i=0; i<len+1; i++){
            // 몬스터 공격 받는지 확인
            if(i == attacks[idx][0]){
                cnt = 0;
                ans -= attacks[idx][1];
                if(ans <= 0) return -1;
                idx++;
                continue;
            }
            cnt++;
            if(cnt == bandage[0]){
                ans += bandage[1] + bandage[2];
                cnt = 0;
            }else{
                ans += bandage[1];
            }
            ans = Math.min(ans, health);
            if(ans <= 0) return -1;
        }
        return ans;
    }
}