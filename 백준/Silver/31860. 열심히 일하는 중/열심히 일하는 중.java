import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> list = new ArrayList<>();

        int y = 0;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p > k){
                // 만족도 계산
                int ny = (int)Math.floor((double)y / 2) + p;
                list.add(ny);
                y = ny;
                // 중요도 계산
                if(p - m > k) q.add(p - m);
            }
        }
        StringBuilder sb = new StringBuilder();
        int s = list.size();
        sb.append(s).append("\n");
        for(int i=0; i<s; i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}