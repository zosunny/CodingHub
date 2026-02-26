/*
    만들 수 있는 소수 개수 (11 = 011)
    
    1. 배열로 분리
    2. 부분집합
    3. 순열
    4. 맨 앞 0 확인
    5. 소수 검증
    -> 2^10 + 10!
*/
import java.util.*;


class Solution {
    
    static int len;
    static int ans;
    static int[] arr;
    static Set<Integer> set;
    
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i<(int)Math.sqrt(num)+1; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public static void permu(int cnt, List<Integer> list, int n, int[] input, boolean[] select){
        if(cnt == n){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                sb.append(input[i]);
            }
            String str = sb.toString();
            if(str.length() != 0 && isPrime(Integer.parseInt(str))) set.add(Integer.parseInt(str));
            return;
        }
        for(int i=0; i<n; i++){
            if(select[i]) continue;
            input[cnt] = list.get(i);
            select[i] = true;
            permu(cnt+1, list, n, input, select);
            select[i] = false;
        }
    }
    
    public static void subset(int cnt, boolean[] select){
        if(cnt == len){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<len; i++){
                if(select[i]) list.add(arr[i]);
            }
            int n = list.size();
            int[] input = new int[len];
            boolean[] visited = new boolean[len];
            permu(0, list, n, input, visited);
            return;
        }
        select[cnt] = true;
        subset(cnt+1, select);
        select[cnt] = false;
        subset(cnt+1, select);
    }
    
    public int solution(String numbers) {
        len = numbers.length();
        set = new HashSet<>();
        
        arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        
        boolean[] select = new boolean[len];
        subset(0, select);
        
        return set.size();
    }
}