import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);


        int s = arr[0][0];
        int e = arr[0][1];
        int ans = 0;
        for(int i=1; i<n; i++) {
            // 1. 선이 겹치는 경우
            if(arr[i][0] <= e){
                e = Math.max(e, arr[i][1]);
            }
            // 2. 선이 겹치지 않는 경우
            else{
                ans += e - s;
                s = arr[i][0];
                e = arr[i][1];
            }
        }
        ans += e - s;
        System.out.println(ans);
    }
}