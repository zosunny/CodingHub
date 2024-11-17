class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int x=brown; x>=0; x--){
            int y = (brown / 2) + 2 - x;
            if(x < y) continue;
            if(x * y == (brown + yellow)){
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}