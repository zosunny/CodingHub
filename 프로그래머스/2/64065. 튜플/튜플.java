import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        int n = arr.length;
        int[] answer = new int[n];
        
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        
        for(String x : arr){
            String[] tmp = x.split(",");
            for(String y : tmp){
                int now = Integer.parseInt(y);
                if(!set.contains(now)){
                    set.add(now);
                    answer[idx++] = now;
                }
            }
        }
        
        return answer;
    }
}