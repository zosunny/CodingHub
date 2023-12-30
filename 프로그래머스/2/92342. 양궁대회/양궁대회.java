import java.util.*;

class Solution {
    
    static int maxScore = 0;
    static int[] tmp;
    
    // 라이언의 점수 계산해 어피치와 비교
    public static void calc(int[] lion, int[] info){
        int apeaches = 0;
        int lions = 0;
        for(int i=0; i<11; i++){
            // 화살 개수에 따라 배점
            if(info[i] == 0 && lion[i] == 0) continue;
            if(info[i] >= lion[i]){
                apeaches += Math.abs(10-i);
            }else{
                lions += Math.abs(10-i);
            }
        }
        
        int tmpScore = lions-apeaches;
        
        // 라이언의 점수가 더 높고 이전 최댓값과 같거나 큰 경우
        if(tmpScore > 0 && tmpScore >= maxScore){
            
            // System.out.print("라이언 과녁 결과: ");
            // for(int x : lion){
            //     System.out.print(x + " ");
            // }
            // System.out.println();
            // System.out.println("점수 차: " + tmpScore + ", 기존 최대 점수 차: " + maxScore);
            // System.out.println("--------------------");
            
            // 기존 최댓값과 같으면
            if(tmpScore == maxScore){
                // 낮은 점수를 더 많이 맞춘 경우를 tmp에 임시저장
                for(int i=10; i>=0; i--){
                    if(lion[i] > tmp[i]){
                        // System.out.println("기존 최댓값과 같은데 낮은 점수가 더 커서 교환");
                        tmp = lion.clone();
                        break;
                    }else if(lion[i] < tmp[i]){
                        break;
                    }
                }
            }
            // 기존 점수 차의 최댓값보다 큰경우 최댓값 재설정, tmp에 값 임시저장
            else{
                maxScore = tmpScore;
                tmp = lion.clone();
            }
        }
    }
    
    // 0 ~ 10 중복 조합
    public static void combi(int cnt, int start, int n, int[] input, int[] info){
        if(cnt == n){
            int[] lion = new int[11];
            for(int i=0; i<n; i++){
                int score = input[i];
                lion[score] += 1;
            }
            // 점수 계산
            calc(lion, info);
            return;
        }
        for(int i=start; i<11; i++){
            input[cnt] = i;
            combi(cnt+1, i, n, input, info);
        }
    }
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        int[] input = new int[n];
        tmp = new int[11];
        // 라이언의 화살 결과 경우의 수
        combi(0, 0, n, input, info);
        
        
        // 라이언이 우승할 수 없는 경우
        if(maxScore == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        // 라이언이 우승하는 경우
        else{
            answer = new int[11];
            for(int i=0; i<11; i++){
                answer[i] = tmp[i];
            }
        }
        
        return answer;
    }
}