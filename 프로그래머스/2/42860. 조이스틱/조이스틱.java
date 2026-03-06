import java.util.*;

/*
    1) min(x-'A', 'Z'-x+1)
    2) 좌우이동 경우에 대한 방향 체크
*/

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int cnt = n - 1;
        
        for(int i=0; i<n; i++){
            // 1)
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 2)
            // 다음 연속된 A의 위치 찾기(연속일 때만 왕복 최솟값 의미 있음)
            int idx = i + 1;
            while(idx < n && name.charAt(idx) == 'A') idx++;
            
            cnt = Math.min(cnt, (i * 2) + (n - idx));
            cnt = Math.min(cnt, (n - idx) * 2 + i);
        }
        
        return answer + cnt;
    }
}