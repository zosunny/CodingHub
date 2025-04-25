import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", " ");
        String[] arr = s.split(" ");
        int[] answer = new int[arr.length];
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        
        for(String x : arr){
            String[] tmp = x.split(",");
            for(String y : tmp){
                int n = Integer.parseInt(y);
                if(set.contains(n)) continue;
                answer[idx++] = n;
                set.add(n);
            }
        }
        
        return answer;
    }
}