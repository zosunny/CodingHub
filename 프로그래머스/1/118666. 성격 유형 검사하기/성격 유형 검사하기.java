import java.util.*;

class Solution {
    
    static int len;
    static char[] mbti;
    static int[] sc;
    static String answer = "";
    static char[][] origin = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    
    public static void makeMbti(){
        
        int[] tmp1 = new int[4];
        int[] tmp2 = new int[4];
        
        for(int i=0; i<len; i++){
            char now = mbti[i];
            if(now == 'R'){
                tmp1[0] += sc[i];
            }else if(now == 'T'){
                tmp2[0] += sc[i];
            }else if(now == 'C'){
                tmp1[1] += sc[i];
            }else if(now == 'F'){
                tmp2[1] += sc[i];
            }else if(now == 'J'){
                tmp1[2] += sc[i];
            }else if(now == 'M'){
                tmp2[2] += sc[i];
            }else if(now == 'A'){
                tmp1[3] += sc[i];
            }else if(now == 'N'){
                tmp2[3] += sc[i];
            }
        }
        
        // 크기비교
        for(int i=0; i<4; i++){
            if(tmp1[i] > tmp2[i]){
                answer += origin[i][0];
            }else if(tmp1[i] < tmp2[i]){
                answer += origin[i][1];
            }
            // 점수가 같으면 사전순
            else{
                if((int)origin[i][0] > (int)origin[i][1]){
                    answer += origin[i][1];
                }else{
                    answer += origin[i][0];
                }
            }
        }
    }
    
    public String solution(String[] survey, int[] choices) {
        
        len = survey.length;
        mbti = new char[len];
        sc = new int[len];
        
        // 점수 계산하기
        int score;
        for(int i=0; i<len; i++){
            score = choices[i] - 4;
            // 점수가 음수면 비동의
            if(score < 0){
                mbti[i] = survey[i].charAt(0);
            }
            // 점수가 양수면 동의
            else if(score > 0){
                mbti[i] = survey[i].charAt(1);
            }
            // 그 외 선택 안함
            else{
                mbti[i] = ' ';
            }
            // 점수 넣어줌
            sc[i] = Math.abs(score);
        }
        
        makeMbti();
        
        return answer;
    }
}