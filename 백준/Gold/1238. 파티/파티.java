import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, X;
	static List<Edge>[] list, rlist;
	static int[] dis, rdis;
	static int answer;
	
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
	
	public static void dijk(List<Edge>[] lists, int[] distance, int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.idx]) continue;
			visited[e.idx] = true;
			for(Edge edge : lists[e.idx]) {
				distance[edge.idx] = Math.min(distance[edge.idx], distance[e.idx] + edge.weight);
				pq.add(new Edge(edge.idx, distance[edge.idx]));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 학생 수
		M = Integer.parseInt(st.nextToken());	// 단방향 도로 수
		X = Integer.parseInt(st.nextToken());	// 파티를 벌이는 마을
		
		// 거리 정보 입력
		list = new ArrayList[N+1];
		rlist = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
			rlist[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e, w));
			rlist[e].add(new Edge(s, w));
		}

		dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		rdis = new int[N+1];
		Arrays.fill(rdis, Integer.MAX_VALUE);
		dijk(list, dis, X);
		dijk(rlist, rdis, X);
		
		for(int i=0; i<N+1; i++) {
			answer = Math.max(answer, dis[i] + rdis[i]);
		}
		System.out.println(answer);
	}
}