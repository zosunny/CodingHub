import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 최단경로
        int[][] dis = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }

        // 최단경로일 때의 집하장
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dis[x][y] = Math.min(dis[x][y], d);
            dis[y][x] = Math.min(dis[y][x], d);
            map[x][y] = y;
            map[y][x] = x;
        }

        // 플로이드
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(dis[i][k] != INF && dis[k][j] != INF){
                        if(dis[i][j] > dis[i][k] + dis[k][j]){
                            dis[i][j] = dis[i][k] + dis[k][j];
                            map[i][j] = map[i][k];      // 최단 경로에서 처음 방문하는 노드
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(map[i][j] == 0) sb.append("- ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}