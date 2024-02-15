import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static int n, d, c;
	static List<Point>[] list;
	static int[] dis;
	
	static class Point implements Comparable<Point>{
		int b, s;
		Point(int b, int s){
			this.b = b;
			this.s = s;
		}
		@Override
		public int compareTo(Point o) {
			return this.s - o.s;
		}
	}
	
	public static void dijk(int c) {
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(c, 0));
		dis[c] = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(visited[p.b]) continue;
			visited[p.b] = true;
			for(Point point : list[p.b]) {
				dis[point.b] = Math.min(dis[point.b], dis[p.b] + point.s);
				pq.add(new Point(point.b, dis[point.b]));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list = new ArrayList[n+1];
			for(int i=0; i<n+1; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new Point(a, s));
			}
			dis = new int[n+1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dijk(c);
			int num = 0;
			int time = 0;
			for(int i=0; i<n+1; i++) {
				if(dis[i] != Integer.MAX_VALUE) {
					time = Math.max(time, dis[i]);
					num++;
				}
			}
			System.out.println(num + " " + time);
		}
	}
}