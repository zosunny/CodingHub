import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int T;
    static int N, M, C;
    static int maxTmp;
    static int maxAns;
    
    static int[][] arr;
    
    public static void subset(int cnt, boolean[] select2, int x, int y) {
        if(cnt==M) {
            int tmp = 0;
            int tmpAns = 0;
            for(int i=0; i<M; i++) {
                if(select2[i]) {
                    // 각 일꾼이 선택한 벌통의 벌꿀의 합이 C를 넘어가면 안돼
                    tmp += arr[x][y+i];
                    tmpAns += arr[x][y+i] * arr[x][y+i];
                }
            }
            if(tmp <= C) maxTmp = Math.max(maxTmp, tmpAns);
            return;
        }
        select2[cnt] = true;
        subset(cnt+1, select2, x, y);
        select2[cnt] = false;
        subset(cnt+1, select2, x, y);
    }
    
    public static void combi(int cnt, int start, int[] input, boolean[] select) {
        if(cnt==2) {
            // 각 일꾼이 선택할 수 있는 벌통은 무조건 가로로 연속되어야 함 -> 행이 달라지면 안됨
            for(int idx=0; idx<2; idx++) {
                for(int i=0; i<M-1; i++) {
                    // 한 일꾼의 전, 후 행이 다르면 안돼 돌아가.
                    if((input[idx]+i)/N != (input[idx]+(i+1))/N) {
                        return;
                    }
                }
            }
            int ans = 0;
            // 벌꿀 채취
            for(int i=0; i<2; i++) {
            	boolean[] select2 = new boolean[M];
                subset(0, select2, input[i]/N, input[i]%N); 
                ans += maxTmp;
                maxTmp = 0;
            }
            maxAns = Math.max(maxAns, ans);
            
            return;
        }
        for(int i=start; i<N*N; i++) {
            if(select[i]) continue;
            input[cnt] = i;
            select[i] = true;
            // 첫번째 일꾼이 선택한 벌통부터 M개는 두번째 일꾼이 절대 선택할 수 없음
            combi(cnt+1, i+M, input, select);
            select[i] = false;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            maxTmp = Integer.MIN_VALUE;
            maxAns = Integer.MIN_VALUE;
            
            arr = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] input = new int[2];
            boolean[] select = new boolean[N*N];
            combi(0, 0, input, select);
            
            sb.append("#" + (t+1) + " " + maxAns + "\n");
        }
        System.out.println(sb);
    }
}