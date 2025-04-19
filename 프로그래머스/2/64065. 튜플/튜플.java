import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", " ");
        String[] arr = s.split(" ");
        int[] answer = new int[arr.length];
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<String> set = new HashSet<>();
        int idx = 0;
        
        for(String a : arr){
            String[] tmp = a.split(",");
            for(String t : tmp){
                if(set.contains(t)) continue;
                answer[idx++] = Integer.parseInt(t);
                set.add(t);
            }
        }
        
        return answer;
    }
}