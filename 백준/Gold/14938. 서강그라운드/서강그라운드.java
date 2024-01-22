import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int n, m, r;
	static int[] items;
	static List<Edge>[] list;
	static boolean[] visited;
	static int[] dis;
	static int answer = Integer.MIN_VALUE;
	
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
	
	public static void dijk(int start, int m) {
		visited = new boolean[n+1];
		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
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
		// 얻을 수 있는 아이템 개수
		int tmp = 0;
		for(int i=1; i<n+1; i++) {
			if(dis[i] <= m) tmp += items[i];
		}
		answer = Math.max(answer, tmp);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 지역 개수
		m = Integer.parseInt(st.nextToken());	// 수색 범위
		r = Integer.parseInt(st.nextToken());	// 길의 개수
		
		// 각 지역별 아이템 수
		items = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, dis));
			list[b].add(new Edge(a, dis));
		}
		// 각 낙하 지점부터 수색
		for(int i=0; i<n+1; i++) {
			dijk(i, m);
		}
		System.out.println(answer);
	}
}