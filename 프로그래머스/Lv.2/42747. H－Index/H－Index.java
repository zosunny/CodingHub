import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);
        
        // h(1)번 이상 인용된 논문이 h(2)편 이상 -> 둘 중 최솟값 중 모든 경우의 최댓값을 구하면 됨
        for(int i=0; i<len; i++){
            answer = Math.max(answer, Math.min(citations[i], len - i));
        }
        
        return answer;
    }
}