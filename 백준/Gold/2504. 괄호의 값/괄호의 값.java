import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        Stack<Object> s = new Stack<>();

        int ans = 0;
        int tmp = 1;

        for(int i=0; i<n; i++){
            char c = str.charAt(i);

            if(c == '('){
                s.push(c);
                tmp *= 2;
            }else if(c == '['){
                s.push(c);
                tmp *= 3;
            }else if(c == ')'){
                if(s.isEmpty() || (char)s.peek() != '('){
                    ans = 0;
                    break;
                }
                if(str.charAt(i-1) == '('){
                    ans += tmp;
                }
                s.pop();
                tmp /= 2;
            }else if(c == ']'){
                if(s.isEmpty() || (char)s.peek() != '['){
                    ans = 0;
                    break;
                }
                if(str.charAt(i-1) == '['){
                    ans += tmp;
                }
                s.pop();
                tmp /= 3;
            }
        }
        if(!s.isEmpty()) ans = 0;
        System.out.println(ans);
    }
}