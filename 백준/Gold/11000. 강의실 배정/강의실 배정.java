import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point>{
        int s, e;
        Point(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Point o){
            int tmp = this.s - o.s;
            if(tmp == 0) return this.e - o.e;
            else return tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq1.add(new Point(s, e));
        }
        // 가장 빨리 시작하고 가장 빨리 끝나는 수업부터 확인
        int cnt = 1;
        int end = 0;
        while(!pq1.isEmpty()){
            Point p = pq1.poll();
            if(end <= p.s) {
                pq2.add(p.e);
            } else {
                cnt++;
                pq2.add(p.e);
                pq2.add(end);
            }
            end = pq2.poll();
        }
        System.out.println(cnt);
    }
}