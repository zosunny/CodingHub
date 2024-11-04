import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=n-1; i>=0; i--){
            min = Math.min(min, arr[i]);
            ans = Math.max(ans, min*(n-i));
        }
        System.out.println(ans);
    }
}