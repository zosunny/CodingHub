import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            // 이전에 값이 있으면 해당 값에 추가
            map.put(str, map.getOrDefault(str, 0) + num);
        }

        // 5인 경우 탐색
        String ans = "NO";
        for(String key : map.keySet()){
            if(map.get(key) == 5) ans = "YES";
        }
        System.out.println(ans);
    }
}