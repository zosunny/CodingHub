import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long p, q;
    static Map<Long, Long> map = new HashMap<>();

    static long calc(long x){
        if(x == 0) return 1;
        if(map.containsKey(x)) return map.get(x);

        long a = (long)Math.floor(x / p);
        long b = (long)Math.floor(x / q);

        map.put(x, calc(a) + calc(b));
        return map.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        System.out.println(calc(n));
    }
}