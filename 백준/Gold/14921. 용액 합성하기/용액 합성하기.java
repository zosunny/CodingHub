import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int res1 = Integer.MIN_VALUE;
    static int res2 = Integer.MAX_VALUE;

    public static void twoPointer(int s, int e){
        if(s >= e) return;
        int tmp = arr[s] + arr[e];
        if(tmp < 0) {
            res1 = Math.max(res1, tmp);
            twoPointer(s+1, e);
        }else{
            res2 = Math.min(res2, tmp);
            twoPointer(s, e-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer(0, n-1);

        if(Math.abs(res1) <= res2 && res1 != Integer.MIN_VALUE) System.out.println(res1);
        else System.out.println(res2);
    }
}