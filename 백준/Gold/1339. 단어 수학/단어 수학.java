import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = arr[i];
            int len = str.length();
            for(int j=0; j<len; j++){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + (int)Math.pow(10, len - j));
            }
        }

        // 가중치 높은 것부터. 내림차순 정렬
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int num = 9;
        Map<Character, Integer> map2 = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : list){
            map2.put(entry.getKey(), num--);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            String str = arr[i];
            int len = str.length();
            sb = new StringBuilder();
            for(int j=0; j<len; j++){
                sb.append(map2.get(str.charAt(j)));
            }
            ans += Integer.parseInt(sb.toString());
        }
        System.out.println(ans);
    }
}