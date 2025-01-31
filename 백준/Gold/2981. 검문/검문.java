import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int tmp = arr[1] - arr[0];
        for(int i=1; i<n-1; i++){
            tmp = gcd(tmp, arr[i+1] - arr[i]);
        }

        // 최대공약수의 약수
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<= tmp; i++){
            if(tmp % i == 0) sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}