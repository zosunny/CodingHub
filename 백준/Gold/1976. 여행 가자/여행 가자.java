import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] set;
	
	public static int find(int x) {
		// 인덱스와 그 값이 같으면 최고 대표
		if(x == set[x]) {
			return x;
		}
		// 아니면 다시 대표 찾아서 현재 x의 대표로 교체
		else {
			return set[x] = find(set[x]);
		}
	}
	
	public static void union(int a, int b) {
		// 각각의 대표 찾기
		a = find(a);
		b = find(b);
		
		// 둘의 대표가 다르면 합병
		if(a != b) {
			set[b] = a;
		}
	}

	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 도시의 수
		M = Integer.parseInt(br.readLine());	// 여행 계획 도시의 수
		
		// 도시별 대표 생성
		set = new int[N+1];
		for(int i=1; i<N+1; i++) {
			set[i] = i;
		}
		
		// union-find
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		// 계획된 도시들의 대표도시가 같으면 연결된 도시.
		st = new StringTokenizer(br.readLine());
		int a = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<M; i++) {
			if(find(Integer.parseInt(st.nextToken())) != a) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");		
	}
}