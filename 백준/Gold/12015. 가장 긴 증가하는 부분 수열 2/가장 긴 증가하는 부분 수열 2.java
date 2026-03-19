import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<N; i++){
            if(arr[i] > list.get(list.size()-1)) list.add(arr[i]);
            else {
                int s = 0;
                int e = list.size() - 1;
                while(s < e){
                    int mid = (s + e) / 2;
                    if(arr[i] > list.get(mid)) s = mid + 1;
                    else e = mid;
                }
                list.set(s, arr[i]);
            }
        }
        System.out.println(list.size());
    }
}