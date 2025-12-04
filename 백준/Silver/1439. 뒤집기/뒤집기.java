import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;
        int ans = 0;

        while(true){
            char c = arr[0];
            int s = -1;
            int e = -1;
            for(int i=1; i<len; i++){
                // 다른 숫자 발견, s 값이 아직 없으면
                if(arr[i] != c && s == -1) s = i;
                // 다른 숫자 발견할 때마다 e 갱신
                if(arr[i] != c) e = i;
            }
            if(s == -1) break;
            // 뒤집기
            for(int i=s; i<e+1; i++){
                if(arr[i] == '0') arr[i] = '1';
                else arr[i] = '0';
            }
            ans++;
        }
        System.out.println(ans);
    }
}