import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            set.add(str);
            StringBuilder sb = new StringBuilder(str);
            String rev = sb.reverse().toString();
            if(set.contains(rev)) {
                System.out.println(rev.length() + " " + rev.charAt(rev.length() / 2));
                break;
            }
        }
    }
}