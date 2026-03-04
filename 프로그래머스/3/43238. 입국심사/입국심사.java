import java.util.*;

/*
    - 한 심사대 = 심사 1명
    - 최소 심사 시간
    - n <= 10억, 심사시간 <= 10억
    
    1. 시간범위 0분~최대 max(times) * n
    2. 이분탐색으로 해당 시간동안 처리 가능한 최대 사람 수 : time/[0] + ... + time/times[i]
    -> 최대 log10억인데 심사시간은 long!!!
*/

class Solution {
    
    static int len;
    static long ans = Long.MAX_VALUE;
    
    public static long calc(long mid, int[] times){
        long cnt = 0;
        for(int i=0; i<len; i++){
            cnt += mid / times[i];
        }
        return cnt;
    }
    
    public static void binarySearch(long s, long e, int n, int[] times){
        if(s > e) return;
        
        long mid = (s + e) / 2;
        
        if(calc(mid, times) >= n){
            ans = Math.min(ans, mid);
            binarySearch(s, mid-1, n, times);
        }else{
            binarySearch(mid+1, e, n, times);
        }
    }
    
    public long solution(int n, int[] times) {
        
        len = times.length;
        Arrays.sort(times);
        
        binarySearch(1L, (long)times[len-1]*n, n, times);
        
        return ans;
    }
}