import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기값
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int cnt = map.size();
        int ans = map.containsKey(c) ? cnt : cnt + 1;

        int s = 0;
        int e = k;
        while(true){
            if(s >= n) break;
            map.put(arr[s], map.get(arr[s]) - 1);
            if(map.get(arr[s]) == 0) {
                map.remove(arr[s]);
                cnt--;
            }
            map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);
            if(map.get(arr[e]) == 1) cnt++;

            int tmp = map.containsKey(c) ? cnt : cnt + 1;
            ans = Math.max(ans, tmp);

            s++;
            e++;
            if(e >= n) e = 0;
        }
        System.out.println(ans);
    }
}
