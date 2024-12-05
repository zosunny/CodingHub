import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] ans;

    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visited[now]) continue;
            // 부모-자식 노드 저장
            ans[now] = x;
            dfs(now);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        visited = new boolean[n+1];
        ans = new int[n+1];
        dfs(1);

        for(int i=2; i<n+1; i++){
            bw.write(ans[i] + " \n");
        }
        bw.flush();
        bw.close();
    }
}