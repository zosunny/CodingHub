import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        int cnt = 1;
        for(int i=1; i<n; i++){
            int s = arr[i][0];
            int e = arr[i][1];
            if(!pq.isEmpty()){
                int p = pq.poll();
                if(s < p){
                    cnt++;
                    pq.add(p);
                    pq.add(e);
                }else pq.add(e);
            }
        }
        System.out.println(cnt);
    }
}