import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        int ans = 0;
        ans += n / 500;
        n %= 500;
        ans += n / 100;
        n %= 100;
        ans += n / 50;
        n %= 50;
        ans += n / 10;
        n %= 10;
        ans += n / 5;
        n %= 5;
        ans += n;

        System.out.println(ans);
    }
}