import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        boolean answer = true;
        
        // 사전순 정렬
        Arrays.sort(phone_book);

        for(int i=0; i<len-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }    
        return true;
    }
}