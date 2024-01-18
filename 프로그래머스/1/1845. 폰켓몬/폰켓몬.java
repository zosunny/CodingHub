import java.util.*;

class Solution {

    public int solution(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }
        
        return set.size() <= len/2 ? set.size() : len/2;
    }
}