import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static int[] arr = new int[101];

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[101];
        q.add(x);
        visited[x] = 1;
        int cnt = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize --> 0){
                int p = q.poll();
                for(int i=1; i<7; i++){
                    int nx = p + i;
                    // 100 넘어가면
                    if(nx >= 100) {
                        ans = Math.min(ans, cnt+1);
                        continue;
                    }
                    // 뱀 또는 사다리면
                    if(arr[nx] != 0 && visited[arr[nx]] != 2){
                        q.add(arr[nx]);
                        visited[arr[nx]] = 2;
                    }
                    // 그 외 주사위
                    else if(visited[nx] == 0){
                        q.add(nx);
                        visited[nx] = 1;
                    }
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            arr[now] = next;
        }

        bfs(1);
        System.out.println(ans);
    }
}