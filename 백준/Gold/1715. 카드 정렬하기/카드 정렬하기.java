import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(pq.isEmpty()) break;
            int y = pq.poll();
            sum += (x + y);
            pq.add(x + y);
        }
        System.out.println(sum);
    }
}