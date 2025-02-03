import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int ans;
    static int[] visited;

    public static boolean check(int x, int y){
        for(int i=1; i<n+1; i++){
            // 열 확인
            if(visited[i] == y) return false;
            // 대각선 확인
            if((x - i) == Math.abs(y - visited[i])) return false;
        }
        return true;
    }

    public static void dfs(int cnt){
        if(cnt == n+1){
            ans++;
            return;
        }
        for(int i=1; i<n+1; i++){
            if(check(cnt, i)){
                visited[cnt] = i;
                dfs(cnt+1);
                visited[cnt] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new int[n+1];
        dfs(1);

        System.out.println(ans);
    }
}