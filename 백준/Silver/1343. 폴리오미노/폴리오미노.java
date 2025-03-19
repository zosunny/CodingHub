import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String[] arr = origin.split("\\.");

        int n = arr.length;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String now = arr[i];
            int len = now.length();
            // 불가능
            if(len % 2 != 0) {
                System.out.println(-1);
                return;
            }
            sb.append("AAAA".repeat(len / 4));
            sb.append("BB".repeat(len % 4 / 2));

            if(i != n-1) sb.append(".");
        }

        // 마지막 점
        sb.append(".".repeat(origin.length() - sb.length()));

        System.out.println(sb);
    }
}