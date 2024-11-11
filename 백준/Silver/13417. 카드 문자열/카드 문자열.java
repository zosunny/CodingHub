import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            List<Character> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                char ch = str[i].charAt(0);
                if(!list.isEmpty() && list.get(0) >= ch) list.add(0, ch);
                else list.add(ch);
            }
            for(char x : list) sb.append(x);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}