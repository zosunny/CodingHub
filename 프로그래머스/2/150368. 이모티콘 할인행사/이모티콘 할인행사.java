import java.util.*;

/*
    7^4
    1. 이모티콘 가격 10, 20, 30, 40 중복순열로 배정
    2. 계산
*/

class Solution {
    
    static int n;
    static int m;
    static int[] dc = {10, 20, 30, 40};
    static int[] answer;
    
    public static void calc(int[] input, int[][]users, int[]emoticons){
        int num = 0;
        int price = 0;
        for(int i=0; i<n; i++){
            int tmp = 0;
            for(int j=0; j<m; j++){
                if(users[i][0] > input[j]) continue;    // 할인율이 기준보다 작으면 제외
                tmp += emoticons[j] * (1 - ((float)input[j] / 100));
            }
            
            if(tmp >= users[i][1]) num++;
            else price += tmp;
        }
        
        // 최댓값 갱신
        if(answer[0] < num){
            answer[0] = num;
            answer[1] = price;
        }else if(answer[0] == num && answer[1] < price){
            answer[1] = price;
        }
    }
    
    public static void permu(int cnt, int[] input, int[][] users, int[] emoticons){
        if(cnt == m){
            calc(input, users, emoticons);
            return;
        }
        for(int i=0; i<4; i++){
            input[cnt] = dc[i];
            permu(cnt+1, input, users, emoticons);
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = users.length;
        m = emoticons.length;
        
        int[] input = new int[m];
        permu(0, input, users, emoticons);
        
        return answer;
    }
}