import java.util.*;

/*
    diff : 현재 퍼즐 난이도
    time_cur : 현재 퍼즐 소요 시간
    time_prev : 이전 퍼즐 소요 시간
    level : 숙련도
    
    1. diff <= level 이면, time_cur 만큼 시간 사용
    2. diff > level 이면, (diff - level) 번 틀림. 틀릴 때마다 (time_cur + time_prev) 만큼 시간 사용
                        이전 퍼즐 다시 풀 땐 난이도 상관 없이 틀리지 않음. 추가로 time_cur 만큼 시간 사용
                        즉, (diff - level) * (time_cur + time_prev) + time_cur
                        
    limit 안에 모든 퍼즐 해결하기 위한 숙련도의 최솟값은?
*/

class Solution {
    
    static int len;
    static int ans;
    
    public static long calc(int m, int[] diffs, int[] times){
        long res = 0;
        for(int i=0; i<len; i++){
            if(diffs[i] <= m){
                res += times[i];
            }
            else{
                res += (diffs[i] - m) * (times[i] + times[i-1]) + times[i];
            }
        }
        return res;
    }
    
    public static void binary_search(int s, int e, int[] diffs, int[] times, long limit){
        if(s > e) return;
        int m = (s + e) / 2;
        // 숙련도가 m일 때 시간 계산
        long time = calc(m, diffs, times);
        
        if(time > limit){
            binary_search(m+1, e, diffs, times, limit);
        }else{
            ans = m;
            binary_search(s, m-1, diffs, times, limit);
        }
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        len = diffs.length;
        int max_diff = 0;
        for(int i=0; i<len; i++){
            max_diff = Math.max(max_diff, diffs[i]);
        }
        
        // 숙련도 이분탐색
        binary_search(1, max_diff, diffs, times, limit);
        
        return ans;
    }
}