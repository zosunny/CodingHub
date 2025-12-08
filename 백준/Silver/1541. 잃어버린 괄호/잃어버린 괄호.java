import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] plus = br.readLine().split("-");
        int len = plus.length;
        for(int i=0; i<len; i++){
            if(!plus[i].contains("+")) continue;
            // 덧셈 계산
            String[] tmp = plus[i].split("\\+");
            int l = tmp.length;
            int sum = 0;
            for(int j=0; j<l; j++){
                sum += Integer.parseInt(tmp[j]);
            }
            plus[i] = Integer.toString(sum);
        }
        // 뺄셈 계산
        int ans = Integer.parseInt(plus[0]);
        for(int i=1; i<len; i++){
            ans -= Integer.parseInt(plus[i]);
        }
        System.out.println(ans);
    }
}
