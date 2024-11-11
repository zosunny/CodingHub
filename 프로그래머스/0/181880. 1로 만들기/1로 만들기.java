class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int now : num_list){
            while(now > 1) {
                now /= 2;
                answer++;
            }
        }
        return answer;
    }}