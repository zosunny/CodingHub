import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int xs, ys;
    static int xe, ye;
    static final int INF = Integer.MAX_VALUE;
    static Point[] node;
    static long[][] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());

        node = new Point[8];
        node[0] = new Point(xs, ys);
        node[7] = new Point(xe, ye);

        dis = new long[8][8];
        for(int i=0; i<8; i++){
            Arrays.fill(dis[i], INF);
        }

        // 1. 출발지에서 도착지까지 점프로 이동했을 때
        dis[0][7] = dis[7][0] = Math.abs(xs - xe) + Math.abs(ys - ye);

        for(int i=1; i<7; i+=2){
            st = new StringTokenizer(br.readLine());
            node[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            node[i+1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 2. 텔레포트로 이동했을 때 시간이랑 점프했을 때 시간이랑 비교
            dis[i][i+1] = dis[i+1][i] = Math.min(Math.abs(node[i].x - node[i+1].x) + Math.abs(node[i].y - node[i+1].y), 10);
        }

        // 모든 점(시작점, 텔레포트점, 도착점)에 대해 점프로 가는 경우 계산
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                dis[i][j] = Math.min(dis[i][j], Math.abs(node[i].x - node[j].x) + Math.abs(node[i].y - node[j].y));
            }
        }

        // 플로이드 워샬
        for(int k=0; k<8; k++){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        // 시작점 0에서 도착점 7로 가는 최단시간
        System.out.println(dis[0][7]);
    }
}