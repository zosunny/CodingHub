import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());
        if(arr[n-1] < list.get(0)) System.out.println(-1);
        else{
            int ans = 0;
            while(!list.isEmpty()){
                for(int i=0; i<n; i++){
                    for(int j=0; j<list.size(); j++){
                        if(arr[i] >= list.get(j)){
                            list.remove(j);
                            break;
                        }
                    }
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}