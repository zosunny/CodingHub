import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static final int INF = Integer.MAX_VALUE;
    static int[][] dis;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dis = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;              // 자기자신 거리
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dis[x-1][y-1] = Math.min(dis[x-1][y-1], d);     // 중복 간선은 최솟값만 저장
        }

        // 플로이드-워셜
        for(int k = 0; k<n; k++){           // 중간 노드
            for(int i=0; i<n; i++){         // 출발 노드
                for(int j=0; j<n; j++){     // 도착 노드
                    if(dis[i][k] != INF && dis[k][j] != INF){       // 지나갈 수 있는 경우만
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dis[i][j] != INF) sb.append(dis[i][j] + " ");
                else sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}