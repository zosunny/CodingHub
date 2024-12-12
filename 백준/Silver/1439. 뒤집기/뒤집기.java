import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int zero = 0;
        int one = 0;
        if(arr[0] == '0') zero++;
        else one++;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                if(arr[i] == '0') zero++;
                else one++;
            }
        }
        System.out.println(Math.min(zero, one));
    }
}