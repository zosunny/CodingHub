import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열
        int[] dpUp = new int[n];
        Arrays.fill(dpUp, 1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) dpUp[i] = Math.max(dpUp[i], dpUp[j]+1);
            }
        }

        // 가장 긴 감소하는 부분 수열 찾기
        int[] dpDown = new int[n];
        Arrays.fill(dpDown, 1);
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(arr[j] < arr[i]) dpDown[i] = Math.max(dpDown[i], dpDown[j]+1);
            }
        }

        // 가장 긴 길이 찾기
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dpUp[i] + dpDown[i] - 1);
        }
        System.out.println(ans);
    }
}