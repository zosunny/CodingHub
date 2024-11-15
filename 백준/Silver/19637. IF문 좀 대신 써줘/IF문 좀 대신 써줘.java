import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static String tmp;
    static String[][] arr;

    public static void binarySearch(int s, int e, int num){
        if(s > e) return;
        int mid = (s + e) / 2;
        // 현재 기준의 전투력 상한값
        int flag = Integer.parseInt(arr[mid][1]);
        // 전투력 상한값보다 num이 작거나 같으면
        if(flag >= num) {
            tmp = arr[mid][0];
            binarySearch(s, mid-1, num);
        }else binarySearch(mid+1, e, num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 전투력 칭호 저장
        arr = new String[n][2];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().split(" ");
        }

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(br.readLine());
            binarySearch(0, n, num);
            sb.append(tmp + "\n");
        }
        System.out.println(sb.toString());
    }
}