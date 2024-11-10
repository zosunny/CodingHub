import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if(n < 5 && n % 2 != 0) System.out.println(-1);
        else{
            int cnt = 0;
            // 5원 짜리 계산
            int tmp = (int) n / 5;
            if(n % 2 != 0){
                if(tmp % 2 == 0) {
                    cnt = tmp - 1;
                    n = n - (5 * (tmp - 1));
                }else{
                    cnt = tmp;
                    n = n - (5 * tmp);
                }
            }else{
                if(tmp % 2 != 0) {
                    cnt = tmp - 1;
                    n = n - (5 * (tmp - 1));
                }else{
                    cnt = tmp;
                    n = n - (5 * tmp);
                }
            }
            // 2원짜리 계산
            cnt += (int) n / 2;
            System.out.println(cnt);
        }
    }
}