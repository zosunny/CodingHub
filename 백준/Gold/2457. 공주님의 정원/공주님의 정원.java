import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            if(tmp == 0) tmp = o.e - this.e;
            return tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            arr[i] = new Point(sx*100+sy, ex*100+ey);
        }

        Arrays.sort(arr);

        // 3.1 - 11.30
        int tmp = 301;
        int maxE = 0;
        int cnt = 0;
        int i = 0;

        while(tmp <= 1130){
            boolean flag = false;
            // 현재 날짜보다 이전에 피는 꽃이 있으면
            while(i < n && arr[i].s <= tmp){
                maxE = Math.max(maxE, arr[i].e);
                i++;
                flag = true;
            }
            // 덮을 수 있는 꽃이 없음
            if(!flag){
                System.out.println(0);
                return;
            }
            cnt++;
            tmp = maxE;
        }
        System.out.println(cnt);
    }
}