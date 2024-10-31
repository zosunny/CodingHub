import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, r;
    static int cnt;
    static List<Integer>[] list;
    static int[] visit;

    public static void dfs(int x){
        visit[x] = ++cnt;
        for(int i=0; i<list[x].size(); i++){
            int now = list[x].get(i);
            if(visit[now] != 0) continue;
            dfs(now);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        // 2차원 리스트 초기화
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        // 간선 정보
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        // 오름차순 배열
        for(int i=0; i<n+1; i++){
            Collections.sort(list[i]);
        }
        visit = new int[n+1];
        dfs(r);
        // 출력
        for(int i=1; i<n+1; i++){
            System.out.println(visit[i]);
        }
    }
}