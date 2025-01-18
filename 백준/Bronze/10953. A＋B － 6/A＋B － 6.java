import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t --> 0){
            String line = br.readLine();
            int a = Character.getNumericValue(line.charAt(0));
            int b = Character.getNumericValue(line.charAt(2));
            sb.append((a + b)).append("\n");
        }

        System.out.println(sb.toString());
    }
}