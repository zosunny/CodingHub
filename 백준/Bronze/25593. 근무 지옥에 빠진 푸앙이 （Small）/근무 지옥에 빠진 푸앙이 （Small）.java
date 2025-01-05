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
            for(int j=0; j<4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<7; k++){
                    String str = st.nextToken();
                    int time = 0;
                    if(j == 0 || j == 2) time = 4;
                    else if(j == 1) time = 6;
                    else time = 10;
                    map.put(str, map.getOrDefault(str, 0) + time);
                }
            }
        }
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        for(String key : map.keySet()){
            if(key.equals("-")) continue;
            minTime = Math.min(minTime, map.get(key));
            maxTime = Math.max(maxTime, map.get(key));
        }
        if(maxTime - minTime > 12) System.out.println("No");
        else System.out.println("Yes");
    }
}