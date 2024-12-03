import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            if(pq.size() < 2) break;
            long x = pq.poll();
            long y = pq.poll();
            pq.add(x + y);
            pq.add(x + y);
        }

        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}