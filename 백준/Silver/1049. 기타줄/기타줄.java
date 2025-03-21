import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 패키지 오름차순
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int tmp = arr[0][0] * (n / 6);
        int pack =  tmp + arr[0][0];

        // 낱개 오름차순
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int each = tmp + arr[0][1] * (n % 6);

        System.out.println(Math.min(arr[0][1] * n, Math.min(pack, each)));
    }
}