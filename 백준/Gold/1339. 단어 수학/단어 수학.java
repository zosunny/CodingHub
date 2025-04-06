import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            int len = str.length();
            for(int j=0; j<len; j++){
                int ap = str.charAt(j) - 'A';
                arr[ap] += (int)Math.pow(10, len - j - 1);
            }
        }
        Arrays.sort(arr);

        int num = 9;
        int ans = 0;
        for(int i=25; i>=0; i--){
            if(arr[i] != 0) ans += arr[i] * num--;
        }
        System.out.println(ans);
    }
}