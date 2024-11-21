import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int ans;
    static int[][] arr;
    static Integer[][] map;
    
    public static void isBottom(int bottom){
        int top = 0;
        map = new Integer[n][4];
        for(int i=0; i<n; i++){
            // 이번 top 찾기
            for(int j=0; j<6; j++){
                if(arr[i][j] == bottom && j == 0) top = arr[i][5];
                else if(arr[i][j] == bottom && j == 1) top = arr[i][3];
                else if(arr[i][j] == bottom && j == 2) top = arr[i][4];
                else if(arr[i][j] == bottom && j == 3) top = arr[i][1];
                else if(arr[i][j] == bottom && j == 4) top = arr[i][2];
                else if(arr[i][j] == bottom && j == 5) top = arr[i][0];
            }
            int idx = 0;
            int nBottom = 0;
            for(int j=0; j<6; j++){
                if(arr[i][j] == bottom) continue;
                if(arr[i][j] == top) {
                    nBottom = top;       // 다음 bottom
                    continue;
                }
                map[i][idx++] = arr[i][j];
            }
            bottom = nBottom;            // 다음 bottom 바통터치
        }
        // 이 경우 옆면의 최댓값 계산
        for(int i=0; i<n; i++){
            Arrays.sort(map[i], Collections.reverseOrder());
        }
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += map[i][0];
        }
        ans = Math.max(ans, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][6];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1번 주사위의 모든 경우의 수
        for(int i=0; i<6; i++){
            isBottom(arr[0][i]);
        }
        System.out.println(ans);
    }
}