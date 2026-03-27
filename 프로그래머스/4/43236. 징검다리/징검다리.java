import java.util.*;

/*
    거리의 최솟값 중 가장 큰 값
    조합X
    
    범위 : 0 ~ dis
    1) 바위 사이의 거리 < mid : 바위 제거
    2) 제거된 바위 수 > n : mid 축소
    제거된 바위 수 < n : mid 확대
*/

class Solution {
    
    static int answer;
    
    public static int calc(int mid, int[] rocks, int distance){
        int len = rocks.length;
        int cnt = 0;
        int prev = 0;
        
        for(int i=0; i<len; i++){
            if(rocks[i] - prev < mid) {
                cnt++;
            }else{
                prev = rocks[i];
            }
        }
        if(distance - prev < mid) cnt++;
        
        return cnt;
    }
    
    public static void binarySearch(int s, int e, int[] rocks, int n, int distance){
        if(s > e) return;
        int mid = (s + e) / 2;
        if(calc(mid, rocks, distance) <= n) {
            answer = Math.max(answer, mid);
            binarySearch(mid+1, e, rocks, n, distance);
        }else{
            binarySearch(s, mid-1, rocks, n, distance);
        }
    }
    
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        
        binarySearch(0, distance, rocks, n, distance);
        
        return answer;
    }
}