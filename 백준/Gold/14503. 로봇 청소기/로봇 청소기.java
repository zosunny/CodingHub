import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int ans;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void simul(int startX, int startY, int startD){
        int x = startX;
        int y = startY;
        int d = startD;
        while(true){
            if(arr[x][y] == 0){
                arr[x][y] = 2;
                ans++;
            }
            boolean flag = false;
            int nd = d;
            for(int i=0; i<4; i++){
                nd = (nd + 3) % 4;
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(arr[nx][ny] == 0){
                    flag = true;
                    x = nx;
                    y = ny;
                    d = nd;
                    break;
                }
            }
            if(!flag){
                int nx = x + dx[(d+2)%4];
                int ny = y + dy[(d+2)%4];
                if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]==1) break;
                x = nx;
                y = ny;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simul(x, y, d);

        System.out.println(ans);
    }
}
