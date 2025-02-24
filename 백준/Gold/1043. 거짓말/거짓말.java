import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] set;

    public static int find(int x){
        if(set[x] == x) return x;
        else return set[x] = find(set[x]);
    }

    public static void union(int i, int j){
        int a = find(i);
        int b = find(j);
        if(a < b) set[b] = a;
        if(b < a) set[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            set[i] = i;
        }

        // 진실 아는 사람
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int[] know = new int[n1];
        int idx1 = 0;
        if (n1 == 1) {
            int now = Integer.parseInt(st.nextToken());
            know[idx1++] = now;
        } else if (n1 > 1) {
            int next = Integer.parseInt(st.nextToken());
            know[idx1++] = next;
            for (int i = 1; i < n1; i++) {
                union(know[0], Integer.parseInt(st.nextToken()));
            }
        }

        // 각 파티의 집합 만들기
        List<int[]> total = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            int n2 = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int[] tmp = new int[n2];
            tmp[idx++] = first;
            for (int j = 1; j < n2; j++) {
                int next = Integer.parseInt(st.nextToken());
                tmp[idx++] = next;
                union(tmp[0], next);
            }
            total.add(tmp);
        }

        // 진실을 아는 사람의 대표
        int parent = 0;
        if(know.length > 0) parent = find(know[0]);

        // 각 파티의 대표 비교
        int ans = 0;
        for(int i=0; i<m; i++){
            int tmp = find(total.get(i)[0]);
            if(parent != tmp) ans++;
        }
        System.out.println(ans);
    }
}