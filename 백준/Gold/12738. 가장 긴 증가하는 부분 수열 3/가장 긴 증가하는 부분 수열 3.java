import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        List<Integer> tail = new ArrayList<>();
        tail.add(arr[0]);

        for(int i=1; i<N; i++){
            if(arr[i] > tail.get(tail.size()-1)) tail.add(arr[i]);
            else{
                int left = 0;
                int right = tail.size() - 1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(arr[i] > tail.get(mid)) left = mid + 1;
                    else right = mid;
                }
                tail.set(right, arr[i]);
            }
        }
        System.out.println(tail.size());
    }
}