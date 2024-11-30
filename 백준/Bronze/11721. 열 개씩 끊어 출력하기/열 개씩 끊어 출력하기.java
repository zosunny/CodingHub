import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i+=10){
            for(int j=0; j<10; j++){
                if(i+j >= str.length()) break;
                sb.append(str.charAt(i+j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}