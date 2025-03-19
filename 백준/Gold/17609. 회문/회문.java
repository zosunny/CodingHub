import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int palindrome(String str, int s, int e, int cnt){
        if(cnt > 1) return 2;
        while(s < e){
            if(str.charAt(s) == str.charAt(e)){
                s++;
                e--;
                continue;
            }
            return Math.min(palindrome(str, s+1, e, cnt+1), palindrome(str, s, e-1, cnt+1));
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            String str = br.readLine();
            sb.append(palindrome(str, 0, str.length()-1, 0)).append("\n");
        }

        System.out.println(sb);
    }
}