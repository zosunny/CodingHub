import java.util.*;

class Solution {
    
    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int len = answers.length;
        int len1 = one.length;
        int len2 = two.length;
        int len3 = three.length;
        int[] score = new int[3];
        int[] answer = {};

        int cnt = 0;
        for(int i=0; i<len; i++){
            // 1번
            if(answers[i] == one[cnt%len1]) score[0]++;
            // 2번
            if(answers[i] == two[cnt%len2]) score[1]++;
            // 3번
            if(answers[i] == three[cnt%len3]) score[2]++;
            cnt++;
        }
        
        int maxScore = Integer.MIN_VALUE;
        for(int x : score) maxScore = Math.max(maxScore, x);
        
        // 다득점자
        int num = 0;
        boolean[] check = new boolean[3];
        for(int i=0; i<3; i++){
            if(score[i] >= maxScore) {
                check[i] = true;
                num++;
            }
        }
        
        answer = new int[num];
        int idx = 0;
        for(int i=0; i<3; i++){
            if(check[i]) answer[idx++] = i + 1;
        }
        
        return answer;
    }
}