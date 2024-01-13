class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width = 0;  // 가로
        int height = 0;  // 세로
        int limit = yellow + brown;
        
        for(int x=3; x<limit; x++){
            width = x;
            height = limit / x;
            // width >= height 여야 함
            if(width < height) continue;
            // brown = 2width + 2height - 4
            if(brown == (2*width + 2*height - 4)) break;
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}