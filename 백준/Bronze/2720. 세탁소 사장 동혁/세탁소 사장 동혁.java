import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append((n / 25) + " ");
            n %= 25;
            sb.append((n / 10) + " ");
            n %= 10;
            sb.append((n / 5) + " ");
            n %= 5;
            sb.append(n + "\n");
        }
        System.out.println(sb.toString());
    }
}