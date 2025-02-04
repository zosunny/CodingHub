import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int n = Math.max(Math.abs(x1), Math.max(Math.abs(y1), Math.max(Math.abs(x2), Math.abs(y2))));

        int r = x2 - x1 + 1;
        int c = y2 - y1 + 1;

        int[][] arr = new int[r][c];

        int num = 2;
        int cnt = 1;
        int idx = 0;
        int x = -x1;
        int y = -y1;
        int color = r * c;
        if(x >= 0 && y >= 0 && x < r && y < c) {
            arr[x][y] = 1;
            color--;
        }
        boolean flag = false;
        int maxNum = 0;

        while(true){
            if(color == 0){
                flag = true;
                break;
            }
            for(int i=0; i<2; i++){
                for(int j=0; j<cnt; j++){
                    int nx = x + dx[idx % 4];
                    int ny = y + dy[idx % 4];
                    if(nx < 0 || ny < 0  || nx >= r || ny >= c) {
                        x = nx;
                        y = ny;
                        num++;
                        continue;
                    }
                    maxNum = Math.max(maxNum, num);
                    arr[nx][ny] = num++;
                    color--;
                    x = nx;
                    y = ny;
                }
                if(flag) break;
                idx++;
            }
            if(flag) break;
            cnt++;
        }

        int maxLen = String.valueOf(maxNum).length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (j > 0) sb.append(" ");
                sb.append(String.format("%" + maxLen + "d", arr[i][j]));
            }
            if (i < r-1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}