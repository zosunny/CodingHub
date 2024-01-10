import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int len = book_time.length;
        int answer = 0;
        
        // 정렬
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        
        // 리스트로 비교
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            int nowIn = Integer.parseInt(book_time[i][0].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][0].substring(3, 5));
            int nowOut = Integer.parseInt(book_time[i][1].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][1].substring(3, 5));
            for(int j=0; j<list.size(); j++){
                // 리스트에 현재 입실시간보다 앞선 퇴실시간이 있으면 교체
                if(list.get(j) <= nowIn){
                    list.remove(j);
                    break;
                }
            }
            // 퇴실시간+10 추가
            list.add(nowOut+10);
        }
        
        answer = list.size();
        
        return answer;
    }
}