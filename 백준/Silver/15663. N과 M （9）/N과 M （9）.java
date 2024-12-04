import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] select;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void permu(int cnt, int[] input){
        if(cnt == m){
            String str = "";
            for(int i=0; i<m; i++){
                str += input[i] + " ";
            }
            if(!set.contains(str)) {
                sb.append(str + "\n");
                set.add(str);
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(select[i]) continue;
            input[cnt] = arr[i];
            select[i] = true;
            permu(cnt+1, input);
            select[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        select = new boolean[n];
        int[] input = new int[m];
        permu(0, input);

        System.out.println(sb.toString());
    }
}