import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        double left = arr[0] - 0.5;
        int cnt = 01;
        for(int i=0; i<n; i++){
            double right = left + l;
            if(arr[i] > right) {
                cnt++;
                left = arr[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }
}