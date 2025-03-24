import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        int[] arr = new int[j];
        for(int i=0; i<j; i++){
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int s = 0;
        int e = m - 1;
        int ans = 0;

        for(int i=0; i<j; i++){
            int now = arr[i];
            if(now >= s && now <= e) continue;
            if(now > e){
                int tmp = now - e;
                ans += tmp;
                e += tmp;
                s += tmp;
            }else if(now < s){
                int tmp = s - now;
                ans += tmp;
                e -= tmp;
                s -= tmp;
            }
        }
        System.out.println(ans);
    }
}