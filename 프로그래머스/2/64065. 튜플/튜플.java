import java.util.*;

/*
    중복 가능, 순서 다르면 다른 튜플
*/

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<Integer> set = new HashSet<>();
        
        int[] answer = new int[arr.length];
        int idx = 0;
        
        for(String str : arr){
            for(String num : str.split(",")){
                int now = Integer.parseInt(num);
                if(!set.contains(now)){
                    set.add(now);
                    answer[idx++] = now;
                }
            }
        }
        return answer;
    }
}