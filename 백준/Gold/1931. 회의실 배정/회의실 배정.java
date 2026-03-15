import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            if(this.e == o.e) return this.s - o.s;
            else return this.e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        }

        Point[] arr = new Point[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Point(s, e);
        }
        Arrays.sort(arr);

        int ans = 1;
        int e = arr[0].e;
        for(int i=1; i<N; i++){
            if(arr[i].s >= e){
                ans++;
                e = arr[i].e;
            }
        }
        System.out.println(ans);
    }
}