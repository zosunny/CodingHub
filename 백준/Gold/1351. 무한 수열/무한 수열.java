import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long p, q;
    static Map<Long, Long> map = new HashMap<>();

    public static long calc(long n){
        if(map.containsKey(n)) return map.get(n);

        long tmp = calc(n/p) + calc(n/q);
        map.put(n, tmp);

        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(calc(n));;
    }
}