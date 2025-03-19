import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] str = s.split("-");
        
        Arrays.sort(str, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[str.length];
        
        int idx = 0;
        for(String x : str){
            String[] tmp = x.split(",");
            for(String y : tmp){
                if(!set.contains(y)) {
                    set.add(y);
                    answer[idx++] = Integer.parseInt(y);
                }
            }
        }
        
        return answer;
    }
}