import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int palindrome(int s, int e, int cnt, String str){
        if(cnt > 1) return 2;
        while(s < e){
            if(str.charAt(s) == str.charAt(e)){
                s++;
                e--;
                continue;
            }
            return Math.min(palindrome(s+1, e, cnt+1, str), palindrome(s, e-1, cnt+1, str));
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String str = br.readLine();
            int cnt = palindrome(0, str.length()-1, 0, str);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}