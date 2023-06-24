import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] arr = new int[y+1];
        // 전체 배열 최댓값으로 초기화
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[x] = 0;
        
        for(int i=x; i<y+1; i++){
            if(arr[i] == Integer.MAX_VALUE) continue;
            // n을 더했을 때
            if(i+n < y+1) arr[i+n] = Math.min(arr[i+n], arr[i]+1);
            // 2를 곱했을 때
            if(i*2 < y+1) arr[i*2] = Math.min(arr[i*2], arr[i]+1);
            // 3을 곱했을 때
            if(i*3 < y+1) arr[i*3] = Math.min(arr[i*3], arr[i]+1);
        }
        
        if(arr[y] == Integer.MAX_VALUE) answer = -1;
        else answer = arr[y];
        
        return answer;
    }
}