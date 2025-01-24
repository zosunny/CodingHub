import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (!arr.contains(str)) {
                arr.add(str);
            }
        }

        int w1 = 0;
        int w2 = 0;
        int maxCnt = 0;

        for (int i = 0; i < n - 1; i++) {
            String s1 = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                String s2 = arr.get(j);

                int cnt = 0;
                for (int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) break;
                    cnt++;
                }

                if (maxCnt < cnt) {
                    maxCnt = cnt;
                    w1 = i;
                    w2 = j;
                }
            }
        }
        System.out.println(arr.get(w1));
        System.out.println(arr.get(w2));
    }
}