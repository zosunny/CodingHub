import java.util.*;

/*
    N 사용횟수의 최솟값
    ** 최솟값이 8보다 크면 -1 반환
    
    i=1) 5
    i=2) 55, 5+5, 5-5, 5*5, 5/5
    i=3) 555, dp[1]+dp[2], dp[1]-dp[2], dp[1]*dp[2], dp[1]/dp[2],
              dp[2]+dp[1], dp[2]-dp[1], dp[2]*dp[1], dp[2]/dp[1]
    -> 근데 중복값 있을 수 있어서 set 사용
    ** -> 0은 들어갈 수 없음(0으로 나눌 수 없음, 1이상임)
    ** -> 32000 이하만 저장하면 됨(N이 32000이하)
*/

class Solution {
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i=2; i<9; i++){
            // 붙여서 사용하는 경우
            String str = "";
            for(int j=0; j<i; j++){
                str += Integer.toString(N);
            }
            list.get(i).add(Integer.parseInt(str));
            
            // 이전값으로 사칙연산 하는 경우
            for(int j=1; j<i; j++){
                for(int x : list.get(j)){
                    for(int y : list.get(i-j)){
                        int n1 = x + y;
                        int n2 = x - y;
                        int n3 = x * y;
                        int n4 = x / y;
                        if(n1 > 0 && n1 <= 32000) list.get(i).add(n1);
                        if(n2 > 0 && n2 <= 32000) list.get(i).add(n2);
                        if(n3 > 0 && n3 <= 32000) list.get(i).add(n3);
                        if(n4 > 0 && n4 <= 32000) list.get(i).add(n4);
                    }
                }
            }
            if(list.get(i).contains(number)) return i;
        }
        
        
        return -1;
    }
}