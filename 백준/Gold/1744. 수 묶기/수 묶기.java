import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        boolean[] check = new boolean[n];

        int ans = 0;

        // 음수 곱 해주기
        for(int i=1; i<n; i+=2){
            if((arr[i-1] < 0 && arr[i] < 0) || (arr[i-1] < 0 && arr[i] == 0)){
                check[i-1] = true;
                check[i] = true;
                ans += arr[i-1] * arr[i];
            }else break;
        }

        // 양수 곱 해주기
        for(int i=n-2; i>=0; i-=2){
            if(arr[i+1] > 0 && arr[i] > 0 && arr[i+1] != 1 && arr[i] != 1){
                check[i+1] = true;
                check[i] = true;
                ans += arr[i+1] * arr[i];
            }else break;
        }

        // 나머지 계산
        for(int i=0; i<n; i++){
            if(!check[i]) ans += arr[i];
        }

        System.out.println(ans);
    }
}