import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int len = answers.length;
        int maxS = Integer.MIN_VALUE;
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] sol = new int[3];
        for(int i=0; i<len; i++){
            // 삼인방 정답 확인
            if(answers[i] == p1[i%5]) sol[0] += 1;
            if(answers[i] == p2[i%8]) sol[1] += 1;
            if(answers[i] == p3[i%10]) sol[2] += 1;
        }
        int cnt = 1;
        for(int i=0; i<3; i++){
            // 고득점자 확인
            if(maxS == sol[i]) cnt++;
            maxS = Math.max(maxS, sol[i]);
        }
        answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<3; i++){
            if(sol[i] == maxS) answer[idx++] = i + 1;
        }
        return answer;
    }
}