import java.util.*;

class Solution {
    
    static int len;
    static int answer;
    static Set<Integer> set;
    
    public int solution(int[] nums) {
        len = nums.length;

        set = new HashSet<>();
        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }
        
        int v = set.size();
        int N = len/2;
        if(v <= N) answer = v;
        else answer = N;
        
        return answer;
    }
}