import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static int ans;
    static int[] arr;
    static boolean[] select;

    public static void subset(int cnt){
        if(cnt == n){
            int tmp = 0;
            boolean flag = false;
            for(int i=0; i<n; i++){
                if(select[i]) {
                    tmp += arr[i];
                    flag = true;
                }
            }
            if(flag && tmp == s) ans++;
            return;
        }
        select[cnt] = true;
        subset(cnt+1);
        select[cnt] = false;
        subset(cnt+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        select = new boolean[n];
        subset(0);

        System.out.println(ans);
    }
}