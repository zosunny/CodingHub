import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int maxNum;
    static char[][] arr;
    static boolean[] key;
    static List<Point>[] door;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};

    public static void searchEnt(Queue<Point> q, boolean[][] visited){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(arr[i][j] == '*') continue;
                    // 문(대문자)인 경우
                    if(arr[i][j] >= 'A' && arr[i][j] <= 'Z'){
                        int k = arr[i][j] - 'A';
                        // 열쇠 없는 경우
                        if(!key[k]){
                            door[k].add(new Point(i, j));
                        }else{
                            q.add(new Point(i, j));
                            visited[i][j] = true;
                        }
                    }else{
                        q.add(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
    }


    public static int bfs(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        // 입구 찾기
        searchEnt(q, visited);
        int cnt = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            // 문서 찾은 경우
            if(arr[p.x][p.y] == '$') cnt++;
            // 열쇠(소문자)인 경우
            else if(arr[p.x][p.y] >= 'a' && arr[p.x][p.y] <= 'z'){
                int k = arr[p.x][p.y] - 'a';
                if(!key[k]){
                    key[k] = true;
                    // 지금 찾은 열쇠로 열 수 있는 무들 다시 큐에 추가
                    for(Point door : door[k]){
                        if(visited[door.x][door.y]) continue;
                        q.add(door);
                        visited[door.x][door.y] = true;
                    }
                }
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || arr[nx][ny]=='*') continue;
                // 문(대문자)인 경우
                if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z') {
                    int k = arr[nx][ny] - 'A';
                    // 열쇠 없는 경우
                    if (!key[k]) {
                        door[k].add(new Point(nx, ny));
                    } else {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }else{
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            key = new boolean[26];
            door = new ArrayList[26];
            for(int i=0; i<26; i++){
                door[i] = new ArrayList<>();
            }
            maxNum = 0;
            for(int i=0; i<n; i++){
                arr[i] = br.readLine().toCharArray();
            }
            // 보유 열쇠
            String tmp = br.readLine();
            if(!tmp.equals("0")){
                for(char c : tmp.toCharArray()){
                    key[c-'a'] = true;
                }
            }

            sb.append(bfs()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
