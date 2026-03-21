import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;

    public static void dfs(int x, int y, int limit){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny]) continue;
            if(arr[nx][ny] <= limit) continue;
            dfs(nx, ny, limit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        int maxH = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i][j]);
            }
        }

        // 1~maxH까지 물에 잠길 때 안전 영역 갱신
        int ans = 0;
        for(int h=0; h<maxH; h++){
            visited = new boolean[n][n];
            int tmp = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]) continue;
                    if(arr[i][j] > h) {
                        dfs(i, j, h);
                        tmp++;
                    }
                }
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}
