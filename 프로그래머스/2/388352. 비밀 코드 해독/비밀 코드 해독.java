import java.util.*;
/*
    범위 1 ~ n
    m번 시도 가능
    비밀 코드로 가능한 정수 조합 개수
    
    최대 30 중에 5자리 -> 조합 30*29*28*27*26 <= 5,600,000
    
    1) n범위까지 5자리 조합 만들고
    2) q 돌면서 응답(ans) 알맞는지 확인
    3) 가능한 경우 answer++;
*/

class Solution {
    
    static int len;
    static int answer;
    
    public static void check(Set<Integer> set, int[][] q, int[] ans){
        for(int i=0; i<len; i++){
            int cnt = 0;
            for(int j=0; j<5; j++){
                if(set.contains(q[i][j])) cnt++;
            }
            if(cnt != ans[i]) return;
        }
        answer++;
    }
    
    public static void combi(int cnt, int start, int n, boolean[] select, int[][] q, int[] ans){
        if(cnt == 5){
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<=n; i++){
                if(select[i]) set.add(i);
            }
            check(set, q, ans);
            return;
        }
        for(int i=start; i<=n; i++){
            if(select[i]) continue;
            select[i] = true;
            combi(cnt+1, i+1, n, select, q, ans);
            select[i] = false;
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        len = q.length;
        
        boolean[] select = new boolean[n+1];
        combi(0, 1, n, select, q, ans);
        
        return answer;
    }
}