import java.util.*;

/*
    n <= 9
    나누기는 나머지 무시
    최솟값이 8보다 크면 -1 리턴
    
    1(1) = 5
    2(1 + 4) = 55, 5+5, 5-5, 5*5, 5/5
    3(1 + (5 * 4)) = 555
        5+55, 5-55, 5*55, 5/55
        5+(5+5), 5-(5+5), 5*(5+5), 5/(5+5)
        5+(5-5), 5-(5-5), 5*(5-5), 5/(5-5)
        5+(5*5), 5-(5*5), 5*(5*5), 5/(5*5)
        5+(5/5), 5-(5/5), 5*(5/5), 5/(5/5)
    4(1 + (21 * 4))
*/

class Solution {
    public int solution(int N, int number) {
        
        if(number == N) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i=2; i<9; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(N);
            }
            list.get(i).add(Integer.parseInt(sb.toString()));
            for(int j=1; j<i; j++){
                for(int x : list.get(j)){
                    for(int y : list.get(i-j)){
                        int x1 = x + y;
                        int x2 = x - y;
                        int x3 = x * y;
                        int x4 = x / y;
                        if(x1 > 0 && x1 <= 32000) list.get(i).add(x1);
                        if(x2 > 0 && x2 <= 32000) list.get(i).add(x2);
                        if(x3 > 0 && x3 <= 32000) list.get(i).add(x3);
                        if(x4 > 0 && x4 <= 32000) list.get(i).add(x4);
                    }
                    // number 유무 확인
                    if(list.get(i).contains(number)) return i;
                }
            }
        }
        
        return -1;
    }
}