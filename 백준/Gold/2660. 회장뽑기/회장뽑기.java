import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int cnt;
    static int[] ans;
    static List<Integer>[] list;

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(x);
        visited[x] = true;
        cnt = -1;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                int p = q.poll();
                for(int i=0; i<list[p].size(); i++){
                    int nx = list[p].get(i);
                    if(visited[nx]) continue;
                    visited[nx] = true;
                    q.add(nx);
                }
            }
            cnt++;
            boolean flag = true;
            for(boolean b : visited){
                if(!b) {
                    flag = false;
                    break;
                }
            }
            if(flag) return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == -1 && y == -1) break;
            list[x].add(y);
            list[y].add(x);
        }

        ans = new int[n+1];
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i<n+1; i++){
            bfs(i);
            ans[i] = cnt;
            minAns = Math.min(minAns, cnt);
        }
        sb.append(minAns + " ");

        int tmp = 0;
        for(int x : ans){
            if(x == minAns) tmp++;
        }
        sb.append(tmp + " \n");

        for(int i=1; i<n+1; i++){
            if(ans[i] == minAns) sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}