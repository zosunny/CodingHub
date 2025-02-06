import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();
        int maxH = arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(arr[i] > maxH){
                s.add(arr[i]);
                maxH = arr[i];
            }
        }
        System.out.println(s.size()+1);
    }
}