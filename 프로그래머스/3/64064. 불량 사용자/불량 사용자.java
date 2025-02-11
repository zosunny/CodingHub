import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static int ans;
    static List<Integer>[] list;
    static Set<List<Integer>> set;
    
    // 제재 아이디가 맞는지 확인
    public static void check(int[] input){
        
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<m; i++){
            if(!list[i].contains(input[i])) return;
            tmp.add(input[i]);
        }
        
        // 순서만 다른 경우 있는 지 확인
        Collections.sort(tmp);
        if(set.contains(tmp)) return;
        
        set.add(tmp);
        ans++;
    }
    
    public static void permu(int cnt, int[] input, boolean[] select){
        if(cnt == m){
            check(input);
            return;
        }
        for(int i=0; i<n; i++){
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            permu(cnt+1, input, select);
            select[i] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        n = user_id.length;
        m = banned_id.length;
        
        list = new ArrayList[m];
        for(int i=0; i<m; i++){
            list[i] = new ArrayList<>();
        }
        
        // 1. 제재 아이디 확인
        for(int i=0; i<m; i++){
            int len = banned_id[i].length();
            for(int j=0; j<n; j++){
                if(user_id[j].length() == len){
                    boolean flag = true;
                    for(int k=0; k<len; k++){
                        if(banned_id[i].charAt(k) == '*') continue;
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) list[i].add(j);
                }
            }
        }
        
        set = new HashSet<>();
        
        int[] input = new int[m];
        boolean[] select = new boolean[n];
        permu(0, input, select);
        
        return ans;
    }
}