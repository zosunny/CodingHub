import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] dx = {-1, 1};
	static int answer = Integer.MAX_VALUE;
	
	static class Point{
		int x;
		int time;
		Point(int x, int time){
			this.x = x;
			this.time = time;
		}
	}
	
	public static void bfs(int start) {
		boolean[] visited = new boolean[100_001];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(start, 0));
		visited[start] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == K) {
				answer = Math.min(answer, p.time);
			}
			// 뛰는 경우
			if(p.x*2 <= 100000 && !visited[p.x*2]) {
				q.add(new Point(p.x*2, p.time));
				visited[p.x*2] = true;
			}
			// 걷는 경우
			for(int i=0; i<2; i++) {
				int nx = p.x + dx[i];
				int nt = p.time + 1;
				if(nx < 0 || nx > 100000 || visited[nx]) continue;
				q.add(new Point(nx, nt));
				visited[nx] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 수빈이 위치
		K = Integer.parseInt(st.nextToken());	// 동생 위치
		
		bfs(N);
		System.out.println(answer);
	}
}