import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int s, t;
	static List<Edge>[] list;
	static int[] dis;
	
	static class Edge implements Comparable<Edge>{
		int idx;
		int weight;
		Edge(int idx, int weight){
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void dijk(int start) {
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		dis[start] = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(visited[e.idx]) continue;
			visited[e.idx] = true;
			
			for(Edge edge : list[e.idx]) {
				dis[edge.idx] = Math.min(dis[edge.idx], dis[e.idx] + edge.weight);
				pq.add(new Edge(edge.idx, dis[edge.idx]));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e, w));
			list[e].add(new Edge(s, w));
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		dis = new int[n+1];
		Arrays.fill(dis,  Integer.MAX_VALUE);
		dijk(s);

		System.out.println(dis[t]);
	}
}