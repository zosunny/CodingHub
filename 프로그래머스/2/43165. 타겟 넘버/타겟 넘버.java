class Solution {
    
    static int len;
    static int[] input;
    static int answer;
    
    public static void calc(int[] numbers, int target){
        int tmp = 0;
        for(int i=0; i<len; i++){
            // + 연산자일 때
            if(input[i] == 0){
                tmp += numbers[i];
            }
            // - 연산자일 때
            else{
                tmp -= numbers[i];
            }
        }
        // 계산 결과가 타겟 넘버와 같으면
        if(tmp == target) answer++;
    }
    
    public static void permu(int cnt, int[] numbers, int target){
        if(cnt == len){
            // 선택한 연산자로 계산
            calc(numbers, target);
            return;
        }
        for(int i=0; i<2; i++){
            input[cnt] = i;
            permu(cnt+1, numbers, target);
        }
    }
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        
        // +, - 중복 순열
        input = new int[len];
        permu(0, numbers, target);
        
        return answer;
    }
}