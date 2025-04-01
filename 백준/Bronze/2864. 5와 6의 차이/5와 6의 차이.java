import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        String minA = "";
        String maxA = "";
        for(int i=0; i<a.length(); i++){
            char now = a.charAt(i);
            if(now == '5' || now == '6'){
                minA += "5";
                maxA += "6";
            }else{
                minA += now;
                maxA += now;
            }
        }
        String minB = "";
        String maxB = "";
        for(int i=0; i<b.length(); i++){
            char now = b.charAt(i);
            if(now == '5' || now == '6'){
                minB += "5";
                maxB += "6";
            }else{
                minB += now;
                maxB += now;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(minA) + Integer.parseInt(minB) + " ");
        sb.append(Integer.parseInt(maxA) + Integer.parseInt(maxB));
        System.out.println(sb);
    }
}