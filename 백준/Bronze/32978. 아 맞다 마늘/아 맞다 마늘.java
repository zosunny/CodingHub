import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(st.nextToken(), 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            String str = st.nextToken();
            map.put(str, 0);
        }

        for(String key : map.keySet()){
            if(map.get(key) == 1) System.out.println(key);
        }
    }
}