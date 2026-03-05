import java.util.*;

/*
    체육수업을 들을 수 있는 학생의 최댓값
    
    1) lost와 reserve에 같은 학생번호 있는지 확인
    2) lost에서 일단 앞번호에서 빌릴 수 있는지 확인
    3) 안되면 뒷번호에서 빌릴 수 있는지 확인
    4) n - lost에 있는 학생수
*/

class Solution {
    public int solution(int N, int[] lost, int[] reserve) {
        int answer = 0;
        int n = lost.length;
        int m = reserve.length;
        
        Arrays.sort(lost);
        
        // 1)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int x : reserve){
            if(x != -1) set.add(x);
        }
        
        
        // 2), 3)
        for(int i=0; i<n; i++){
            if(lost[i] == -1) {
                continue;
            }
            // 앞번호에 있는z경우, 뒷번호에 있는경우
            if(set.contains(lost[i] - 1)) {
                set.remove(lost[i] - 1);
                lost[i] = -1;
                continue;
            }else if(set.contains(lost[i] + 1)) {
                set.remove(lost[i] + 1);
                lost[i] = -1;
                continue;
            }
            N--;
        }
        
        return N;
    }
}