import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<String, Integer> res = new HashMap<>();
        int ans = 0;
        for(int i=0; i<m; i++){
            int[] copy = arr[i].clone();
            Arrays.sort(copy);
            // 좌표 압축
            Map<Integer, Integer> map = new HashMap<>();
            int cnt = 0;
            for(int x : copy){
                if(!map.containsKey(x)) map.put(x, cnt++);
            }
            // 원본배열을 좌표 압축 값으로 변경
            StringBuilder tmp = new StringBuilder();
            for(int j=0; j<n; j++){
                tmp.append(map.get(arr[i][j])).append(",");
            }
            if(res.containsKey(tmp.toString())) ans += res.get(tmp.toString());
            res.put(tmp.toString(), res.getOrDefault(tmp.toString(), 0) + 1);
        }
        System.out.println(ans);
    }
}