import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dpHigh = new int[3];
        int[] dpLow = new int[3];
        for(int i=0; i<3; i++){
            dpHigh[i] = arr[0][i];
            dpLow[i] = arr[0][i];
        }

        int[] tmpHigh = new int[3];
        int[] tmpLow = new int[3];
        for(int i=1; i<N; i++){
            // 한 칸씩 누적 합 (최대)
            tmpHigh[0] = arr[i][0] + Math.max(dpHigh[0], dpHigh[1]);
            tmpHigh[1] = arr[i][1] + Math.max(Math.max(dpHigh[0], dpHigh[1]), dpHigh[2]);
            tmpHigh[2] = arr[i][2] + Math.max(dpHigh[1], dpHigh[2]);
            // 한 칸씩 누적 합 (최소)
            tmpLow[0] = arr[i][0] + Math.min(dpLow[0], dpLow[1]);
            tmpLow[1] = arr[i][1] + Math.min(Math.min(dpLow[0], dpLow[1]), dpLow[2]);
            tmpLow[2] = arr[i][2] + Math.min(dpLow[1], dpLow[2]);

            dpHigh = tmpHigh.clone();
            dpLow = tmpLow.clone();
        }

        System.out.print(Math.max(Math.max(dpHigh[0], dpHigh[1]), dpHigh[2]) + " " + Math.min(Math.min(dpLow[0], dpLow[1]), dpLow[2]));
    }
}
