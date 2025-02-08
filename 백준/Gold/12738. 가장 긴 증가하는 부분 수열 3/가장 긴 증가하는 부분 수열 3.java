import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for(int i=0; i<n; i++){
            int now = arr[i];

            // 증가수열 마지막 수보다 큰 경우
            if(now > list.get(list.size() - 1)) list.add(now);
            else{
                int left = 0;
                int right = list.size() - 1;
                // 이분탐색
                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= now) right = mid;
                    else left = mid + 1;
                }
                list.set(right, now);
            }
        }

        System.out.println(list.size() - 1);
    }
}