import java.util.*;

class Solution {
    
    static long answer = Long.MAX_VALUE;;
    static int len;
    
    public static void binarySearch(long start, long end, long n, int[] times){
        if(start > end) return;
        long mid = (start + end) / 2;
        // 해당 예상 시간에 따른 처리 가능한 인원 수 계산
        long num = 0;
        for(int i=0; i<len; i++){
            num += mid / times[i];
        }
        if(num >= n) {
            answer = Math.min(answer, mid);
            binarySearch(start, mid-1, n, times);
        }
        else {
            binarySearch(mid+1, end, n, times);
        }
    }
    
    public long solution(int n, int[] times) {
        
        len = times.length;
        
        Arrays.sort(times);
        binarySearch(1, (long)n*times[len-1], n, times);
        
        return answer;
    }
}