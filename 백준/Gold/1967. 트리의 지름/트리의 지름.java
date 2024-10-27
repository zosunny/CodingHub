import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        int y, w;
        Point(int y, int w){
            this.y = y;
            this.w = w;
        }
    }
    static int n;
    static int start;
    static int tmp;
    static int maxDis;
    static int ans;
    static List<Point>[] list;

    public static void dfs(int x, boolean[] visit, int dis){
        if(visit[x]) return;
        visit[x] = true;
        if(list[x].size() == 1 && visit[list[x].get(0).y]){
            if(maxDis < dis){
                maxDis = dis;
                start = x;
            }
            return;
        }
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i).y;
            int ndis = list[x].get(i).w;
            dfs(now, visit, dis+ndis);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        list = new LinkedList[n+1];
        for(int j=0; j<n+1; j++){
            list[j] = new LinkedList<>();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[x].add(new Point(y, w));
            list[y].add(new Point(x, w));
        }
        boolean[] visit = new boolean[n+1];
        maxDis = Integer.MIN_VALUE;
        dfs(1, visit, 0);
        visit = new boolean[n+1];
        maxDis = Integer.MIN_VALUE;
        dfs(start, visit, 0);
        ans = Math.max(ans, maxDis);
        System.out.println(ans);
    }
}