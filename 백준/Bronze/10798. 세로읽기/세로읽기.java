import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[5];

        int len = 0;
        for(int i=0; i<5; i++){
            arr[i] = br.readLine();
            len = Math.max(len, arr[i].length());
        }

        int idx = 0;
        while(true){
            if(idx >= len) break;
            for(int i=0; i<5; i++){
                if(idx >= arr[i].length()) continue;
                sb.append(arr[i].charAt(idx));
            }
            idx++;
        }
        System.out.println(sb);
    }
}