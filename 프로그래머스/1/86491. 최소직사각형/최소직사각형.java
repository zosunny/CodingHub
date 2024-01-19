import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int answer = 0;
        
        // 가로 세로 길이 중 큰 것들과 작은 것들을 따로 모아 각각 중 최댓값을 선택
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for(int i=0; i<len; i++){
            arr1[i] = Math.max(sizes[i][0], sizes[i][1]);
            arr2[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        answer = arr1[len-1] * arr2[len-1];
        
        return answer;
    }
}