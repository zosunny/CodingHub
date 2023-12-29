import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        String[] answer = {};
        
        int len = record.length;
        String[] history = new String[len];
        Map<String, String> map = new HashMap<>();
        
        int idx = 0;
        int cnt = 0;
        // 닉네임 히스토리 확인하기
        for(int i=0; i<len; i++){
            String[] tmp = record[i].split(" ");
            // 입장인 경우
            if(tmp[0].equals("Enter")){
                history[idx++] = "님이 들어왔습니다.";
                map.put(tmp[1], tmp[2]);
                cnt++;
            }
            // 퇴장인 경우
            else if(tmp[0].equals("Leave")){
                history[idx++] = "님이 나갔습니다.";
                cnt++;
            }
            // 닉네임 변경인 경우
            else{
                history[idx++] = "";
                map.put(tmp[1], tmp[2]);
            }
        }
        
        idx = 0;
        answer = new String[cnt];
        // 결과 저장
        for(int i=0; i<len; i++){
            String res = "";
            String[] tmp = record[i].split(" ");
            // 닉네임 변경인 경우는 통과
            if(tmp[0].equals("Change")) continue;
            res += map.get(tmp[1]);
            res += history[i];
            answer[idx++] = res;
        }
        
        return answer;
    }
}