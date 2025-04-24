import java.util.*;

/*
    심사 받는 시간 최소
    사람 수 n <= 10억, 심사관 별 시간 times <= 100,000
    1. 중복 조합 -> 절대 터짐
    범위의 최솟값 -> 이분탐색
    
*/

class Solution {
    
    static int len;
    static long answer = Long.MAX_VALUE;
    
    public static void binarySearch(long s, long e, int n, int[] times){
        if(s > e) return;
        long m = (s + e) / 2;
        // 가능한 인원 계산
        long num = 0;
        for(int i=0; i<len; i++){
            num += m / times[i];
        }
        // 가능한 인원이 총 인원보다 크면 시간 줄여도 됨
        if(num >= n){
            answer = Math.min(answer, m);
            binarySearch(s, m-1, n, times);
        }else{
            binarySearch(m+1, e, n, times);
        }
    }
    
    public long solution(int n, int[] times) {
        
        len = times.length;
        Arrays.sort(times);
        
        binarySearch(1L, (long)times[len-1] * n, n, times);
        
        return answer;
    }
}