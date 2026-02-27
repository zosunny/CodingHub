import java.util.*;

/*
8 <= brown <= 5,000
1 <= yellow <= 2,000,000
w > h

w * h = b + y
w + h = b/2 + 2
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int w=brown/2; w>=0; w--){
            int h = brown / 2 + 2 - w;
            if(w < h) continue;
            if(w * h == brown + yellow){
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        return answer;
    }
}