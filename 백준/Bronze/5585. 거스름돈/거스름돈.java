import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        
        int[] arr = {500, 100, 50, 10, 5, 1};
        
        int ans = 0;
        for(int i=0; i<6; i++){
            ans += n / arr[i];
            n %= arr[i];
        }

        System.out.println(ans);
    }
}