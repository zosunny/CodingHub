import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Edge>[] list;
	static int[] dist;
	
	static class Edge implements Comparable<Edge>{
		int idx;
		int cow;
		Edge(int idx, int cow){
			this.idx = idx;
			this.cow = cow;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cow - o.cow;
		}
	}
	
	public static void dijk(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.idx]) continue;
			visited[e.idx] = true;
			for(Edge edge : list[e.idx]) {
				dist[edge.idx] = Math.min(dist[edge.idx], dist[e.idx] + edge.cow);
				pq.add(new Edge(edge.idx, dist[edge.idx]));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 헛간 개수
		M = Integer.parseInt(st.nextToken());	// 길 개수
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e, c));
			list[e].add(new Edge(s, c));
		}
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijk(1);
		System.out.println(dist[N]);
	}
}