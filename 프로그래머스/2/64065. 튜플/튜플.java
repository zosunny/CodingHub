import java.util.*;

class Solution {
    
    static Set<String> set;
    
    public int[] solution(String s) {
        int[] answer = {};
        
        // 양쪽 {{}} 제거
        s = s.substring(2, s.length()-2);
        // System.out.println(s);
        String[] arr = s.split("},\\{");
        // System.out.println("-----정렬 전-----");
        // for(String x : arr){
        //     System.out.print(x + " | ");
        // }
        // System.out.println();
        
        // 문자열 길이로 정렬
        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
        // System.out.println("-----정렬 후-----");
        // for(String x : arr){
        //     System.out.print(x + " | ");
        // }
        // System.out.println();
        
        // set과 answer에 담기
        set = new HashSet<>();
        answer = new int[arr.length];
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            String[] tmp = arr[i].split(",");
            // set에 없으면 answer에 담고 set에도 넣어주기
            for(String x : tmp){
                if(!set.contains(x)){
                    answer[cnt++] = Integer.parseInt(x);
                    set.add(x);
                }
            }
            
        }
        
        return answer;
    }
}