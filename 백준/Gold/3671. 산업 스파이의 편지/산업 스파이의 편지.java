import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int c;
    static int len;
    static String[] arr;

    static HashSet<Integer> set = new HashSet<>();

    public static boolean isPrime(int num){
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void calc(String[] input2, int check){
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<check; i++){
            // 맨 앞 0은 다 버림
            if(input2[i].equals("0") && !flag) continue;
            else {
                sb.append(input2[i]);
                flag = true;
            }
        }
        if(sb.length() == 0 || sb.toString().equals("1")) return;
        // 소수 판별
        if(isPrime(Integer.parseInt(sb.toString()))) set.add(Integer.parseInt(sb.toString()));
    }

    public static void permu(int cnt, String[] input, boolean[] visit, String[] input2, int check){
        if(cnt == check){
            calc(input2, check);
            return;
        }
        for(int i=0; i<check; i++){
            if(visit[i]) continue;
            input2[cnt] = input[i];
            visit[i] = true;
            permu(cnt+1, input, visit, input2, check);
            visit[i] = false;
        }
    }

    public static void subset(int cnt, boolean[] select, int check){
        if(cnt == len){
            String[] input = new String[check];
            int idx = 0;
            for(int i=0; i<len; i++){
                if(select[i]){
                    input[idx++] = arr[i];
                }
            }
            boolean[] visit = new boolean[check];
            String[] input2 = new String[check];
            permu(0, input, visit, input2, check);
            return;
        }
        select[cnt] = true;
        subset(cnt+1, select, check+1);
        select[cnt] = false;
        subset(cnt+1, select, check);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        for(int i=0; i<c; i++){
            String str = br.readLine();
            len = str.length();
            arr = new String[len];
            for(int j=0; j<len; j++){
                arr[j] = String.valueOf(str.charAt(j));
            }
            boolean[] select = new boolean[len];
            subset(0, select, 0);
            System.out.println(set.size());
            set = new HashSet<>();
        }
    }
}