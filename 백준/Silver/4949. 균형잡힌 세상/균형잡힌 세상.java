import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<Character> left = new Stack<>();

            boolean flag = true;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == '(' || c == '[') left.push(c);
                else if(c == ')'){
                    if(left.isEmpty() || left.peek() != '('){
                        flag = false;
                        break;
                    }else left.pop();
                }else if(c == ']'){
                    if(left.isEmpty() || left.peek() != '['){
                        flag = false;
                        break;
                    }else left.pop();
                }
            }
            if(left.isEmpty() && flag) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}