import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int ans;
    static char[] arr;

    public static void eatBuger(){
        boolean[] check = new boolean[n];
        // 사람 위치에서 왼쪽에 있는 버거부터 먹고, 없으면 오른쪽 버거 먹음.
        for(int i=0; i<n; i++){
            if(arr[i] == 'P'){
                for(int j=i-k; j<=i+k; j++){
                    // 범위 벗어나면 제외
                    if(j < 0 || j >= n) continue;
                    // 버거가 있으면 먹고 먹은 표시하고 끝
                    if(arr[j] == 'H' && !check[j]){
                        ans++;
                        check[j] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[n];
        arr = br.readLine().toCharArray();

        eatBuger();
        System.out.println(ans);
    }
}