import java.util.*;

class Solution {
    
    static ArrayList<Integer> list;
    static int answer;
    
    // k진수로 변환하는 함수
    public static void convert(int n, int k){
        
        list = new ArrayList<>();
        while(n >= k){
            // 나머지
            list.add(n % k);
            // 몫
            n /= k;
        }
        list.add(n);
    }

    // 소수를 판별하는 함수
    public static void isPrime(long tmp){
        for(int i=2; i<=(int)Math.sqrt(tmp); i++){
            if(tmp % i == 0){
                return;
            }
        }
        answer++;
    }
    
    public int solution(int n, int k) {
        
        convert(n, k);
        
        // 0을 기준으로 자른 숫자 소수 판별
        // 이때 뒤에서부터 탐색
        // 1,000,000을 2진수로 변환하면 int범위 초과해 오버플로우 발생
        long tmp = 0;
        for(int i=list.size()-1; i>=-1; i--){
            // 0이면 현재자리까지의 수가 소수인지 판별
            if(i == -1 || list.get(i) == 0){
                if(tmp != 0 && tmp != 1){
                    isPrime(tmp);
                }
                tmp = 0;
            }else{
                tmp = tmp * 10 + list.get(i);
            }
        }
        
        return answer;
    }
}