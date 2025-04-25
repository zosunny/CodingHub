import java.util.*;

class Solution {
    
    static int n;
    static int answer;
    static int[] arr;
    static Set<Integer> set;
    
    public static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i=2; i<(int)Math.sqrt(x)+1; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
    
    public static void permu(int cnt, int[] input, int s, List<Integer> list, boolean[] visit){
        if(cnt == s){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s; i++){
                if(visit[i]) sb.append(list.get(input[i]));
            }
            String str = sb.toString();
            if(str.length() > 0 && isPrime(Integer.parseInt(str))){
                set.add(Integer.parseInt(str));
            }
            return;
        }
        for(int i=0; i<s; i++){
            if(visit[i]) continue;
            visit[i] = true;
            input[cnt] = i;
            permu(cnt+1, input, s, list, visit);
            visit[i] = false;
        }
    }
    
    public static void subset(int cnt, boolean[] select){
        List<Integer> list = new ArrayList<>();
        if(cnt == n){
            for(int i=0; i<n; i++){
                if(select[i]) {
                    list.add(arr[i]);
                }
            }
            int s = list.size();
            int[] input = new int[s];
            boolean[] visit = new boolean[s];
            permu(0, input, s, list, visit);
            return;
        }
        select[cnt] = true;
        subset(cnt+1, select);
        select[cnt] = false;
        subset(cnt+1, select);
    }
    
    public int solution(String numbers) {
        n = numbers.length();
        arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        
        set = new HashSet<>();
        
        boolean[] select = new boolean[n];
        subset(0, select);
        
        return set.size();
    }
}