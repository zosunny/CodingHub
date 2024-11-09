import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long cnt = 0;
        if(n != 0) {
            while(true){
                if(n >= 2){
                    n = (long) Math.ceil(n / 2.0);
                    cnt++;
                }
                if(n == 1) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}