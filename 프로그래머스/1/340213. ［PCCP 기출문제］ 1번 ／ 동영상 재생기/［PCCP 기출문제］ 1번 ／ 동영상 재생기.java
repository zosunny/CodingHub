import java.util.*;
/*
    prev : 10초 전, 현재 위치 10초 미만이면 00:00 
    next : 10초 후, 남은 시간이 10초 미만이면 video_len
    이때, 이동한 위치가 op_start <= ___ <= op_end면 op_end로 이동
*/

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String ans = "";
        
        int v_len = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3, 5));
        int p = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3, 5));
        int op_s = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3, 5));
        int op_e = Integer.parseInt(op_end.substring(0, 2)) * 60 + Integer.parseInt(op_end.substring(3, 5));
        
        int len = commands.length;
        
        for(int i=0; i<len; i++){
            if(p >= op_s && p <= op_e) p = op_e;
            if(commands[i].equals("next")){
                p += 10;
                if(p > v_len) p = v_len;
            }else{
                p -= 10;
                if(p < 0) p = 0;
            }
            if(p >= op_s && p <= op_e) p = op_e;
        }
        
        String m = Integer.toString(p / 60);
        if(m.length() == 1) m = "0" + m;
        String s = Integer.toString(p % 60);
        if(s.length() == 1) s = "0" + s;
        
        ans = m + ":" + s;
        
        return ans;
    }
}