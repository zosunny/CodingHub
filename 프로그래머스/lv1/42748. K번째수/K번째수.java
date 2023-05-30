import java.util.*;

class Solution {
    
    static ArrayList<Integer> list;
    
    public static void calc(int[] arr, int start, int end, int num){
        int[] tmp = Arrays.copyOfRange(arr, start, end+1);
        Arrays.sort(tmp);
        list.add(tmp[num-1]);
    }
    
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = {};
        
        list = new ArrayList<>();
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int num = commands[i][2];
            calc(array, start, end, num);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}