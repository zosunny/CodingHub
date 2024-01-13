import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    // 정현이가 원하는 만큼 구매 가능한지
    public static boolean check(String[] want, int[] number){
        int len = want.length;
        for(int i=0; i<len; i++){
            if(map.containsKey(want[i])){
                if(map.get(want[i]) != number[i]) return false;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int len = discount.length;
        int answer = 0;
        
        // discount 돌면서 체크
        for(int i=0; i<len-9; i++){
            map = new HashMap<>();
            for(int j=i; j<i+10; j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            
            if(check(want, number)) answer++;
        }
        return answer;
    }
}