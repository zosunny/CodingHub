import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int x, y;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        res = (int)((long) y * 100 / x);      // 초기 승률
        int left = 0;
        int right = 1000000000;
        int ans = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            int tmp = (int)((long)(y+mid) * 100 / (x+mid));
            if(tmp != res){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}