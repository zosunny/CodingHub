import java.util.*;

class Solution {
    
    static int len;
    static int answer;
    static boolean[] select1;
    static boolean[] select2;
    static HashSet<Integer> set;
    
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i<(int)Math.sqrt(num)+1; i++){
            if(num % i == 0) return false;
        }
        set.add(num);
        return true;
    }
    
    public static void permu(int cnt, String[] arr, String[] input, int N){
        if(cnt == N){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                sb.append(input[i]);
            }
            if(sb.length() != 0) isPrime(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=0; i<N; i++){
            if(select2[i]) continue;
            input[cnt] = arr[i];
            select2[i] = true;
            permu(cnt+1, arr, input, N);
            select2[i] = false;
        }
    }
    
    public static void subset(int cnt, String numbers, int total){
        if(cnt == len){
            String[] arr = new String[total];
            int idx = 0;
            for(int i=0; i<len; i++){
                if(select1[i]) arr[idx++] = numbers.substring(i, i+1);
            }
            select2 = new boolean[total];
            String[] input = new String [total];
            permu(0, arr, input, total);
            return;
        }
        select1[cnt] = true;
        subset(cnt+1, numbers, total+1);
        select1[cnt] = false;
        subset(cnt+1, numbers, total);
    }
    
    public int solution(String numbers) {
        
        len = numbers.length();
        select1 = new boolean[len];
        set = new HashSet<>();
        subset(0, numbers, 0);
        
        return set.size();
    }
}