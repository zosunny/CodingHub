import java.util.*;

/*
    N 사용횟수의 최솟값
    ** 최솟값이 8보다 크면 -1 반환
    
    i=1) 5
    i=2) 55, 5+5, 5-5, 5*5, 5/5
    i=3) 555, dp[1]+dp[2], dp[1]-dp[2], dp[1]*dp[2], dp[1]/dp[2],
              dp[2]+dp[1], dp[2]-dp[1], dp[2]*dp[1], dp[2]/dp[1]
    -> 근데 중복값 있을 수 있어서 set 사용
    ** -> 0으로 나누는 경우 고려
*/

class Solution {
    public int solution(int N, int number) {
        
        if(number == N) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i=2; i<10; i++){
            // 합친 값
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(N);
            }
            list.get(i).add(Integer.parseInt(sb.toString()));
            
            // 이전 값 연산
            for(int j=1; j<i; j++){
                for(int x : list.get(j)){
                    for(int y : list.get(i-j)){
                        int x1 = x + y;
                        int x2 = x - y;
                        int x3 = x * y;
                        int x4 = x / y;
                        if(x1!=0 && x1<=32000) list.get(i).add(x1);
                        if(x2!=0 && x2<=32000) list.get(i).add(x2);
                        if(x3!=0 && x3<=32000) list.get(i).add(x3);
                        if(x4!=0 && x4<=32000) list.get(i).add(x4);
                    }
                }
                if(list.get(i).contains(number)) return i;
            }
        }
        return -1;
    }
}