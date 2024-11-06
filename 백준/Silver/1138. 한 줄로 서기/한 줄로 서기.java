import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static String[] arr;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        ans = new int[n];
        for(int i=n-1; i>=0; i--){
            int idx = Integer.parseInt(arr[i]);
            if(ans[idx] == 0) ans[idx] = i + 1;
            else{
                for(int j=n-1; j>idx; j--){
                    ans[j] = ans[j-1];
                }
                ans[idx] = i + 1;
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}