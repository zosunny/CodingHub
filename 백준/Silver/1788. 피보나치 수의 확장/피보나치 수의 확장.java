import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int n = Math.abs(N);
        final int MOD_NUM = 1000000000;
        long[] arr = new long[n+1];

        if(n == 0) {
            System.out.println(0 + "\n" + 0);
            return;
        }
        arr[0] = 0;
        arr[1] = 1;
        // 양수인 경우
        if(N > 0) {
            for(int i=2; i<n+1; i++){
                arr[i] = (arr[i-1] + arr[i-2]) % MOD_NUM;
            }
        }
        // 음수인 경우
        else {
            for(int i=2; i<n+1; i++){
                arr[i] = (arr[i-2] - arr[i-1]) % MOD_NUM;
            }
        }
        // 출력
        if(arr[n] < 0) sb.append(-1 + "\n" + Math.abs(arr[n]));
        else sb.append(1 + "\n" + arr[n]);
        System.out.println(sb.toString());
    }
}