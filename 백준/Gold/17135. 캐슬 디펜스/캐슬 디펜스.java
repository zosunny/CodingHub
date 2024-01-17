import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] copy;
	static boolean[] select;
	static int answer;
	static int maxAnswer = Integer.MIN_VALUE;
	
	static class Enemy implements Comparable<Enemy>{
		int x;
		int y;
		int dis;
		Enemy(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		// 거리순, y축 기준 오름차순 정렬
		@Override
		public int compareTo(Enemy o) {
			int tmp = this.dis - o.dis;
			if(tmp == 0) tmp = this.y - o.y;
			return tmp;
		}
	}
	
	// 거리 D이하, 젤 가까운, 왼쪽부터 적 제거, 동시제거 가능
	public static void startGame(int[] input) {
		while(true) {
			Queue<Enemy> kill = new LinkedList<>();
			Set<Integer> set = new HashSet<>();
			// 적 정보 저장
			ArrayList<Point> all = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copy[i][j] == 1) {
						all.add(new Point(i, j));
					}
				}
			}
			int len = all.size();
			// 적이 모두 사라지면 종료
			if(len == 0) {
				maxAnswer = Math.max(maxAnswer, answer);
				answer = 0;
				return;
			}
			// 각 궁수별로 적들 저장
			for(int i=0; i<3; i++) {
				PriorityQueue<Enemy> pq = new PriorityQueue<>();
				for(int j=0; j<len; j++) {
					Point p = all.get(j);
					int ndis = Math.abs(p.x - N) + Math.abs(p.y - input[i]);
					// 거리가 D이하일 때
					if(ndis <= D) {
						pq.add(new Enemy(p.x, p.y, ndis));
					}
				}
				if(!pq.isEmpty()) {
					// 저장한 적들 중 제거 기준에 가장 적합한 적 체크
					Enemy e = pq.poll();
					kill.add(e);
					set.add(e.x * M + e.y);
				}
			}
			// 모든 궁수의 선택이 끝나면 적 제거 및 적의 이동
			while(!kill.isEmpty()) {
				Enemy e = kill.poll();
				copy[e.x][e.y] = 0;
			}
			answer += set.size();
			
			// N-1에 있던 적들은 성으로 이동하면서 제거됨
			for(int i=N-2; i>=0; i--) {
				for(int j=0; j<M; j++) {
					copy[i+1][j] = copy[i][j];
				}
			}
			// 0번째 행 0으로 초기화
			for(int j=0; j<M; j++) {
				copy[0][j] = 0;
			}
		}
	}
	
	public static void combi(int start, int cnt) {
		if(cnt == 3) {
			int[] input = new int[3];
			int idx = 0;
			// 궁수 위치 시키기
			for(int i=0; i<M; i++) {
				if(select[i]) {
					copy[N][i] = 2;
					input[idx++] = i;
				}
			}
			startGame(input);
			// 원본 배열 재복사
			copy = deepcopy(map);
			return;
		}
		for(int i=start; i<M; i++) {
			if(select[i]) continue;
			select[i] = true;
			combi(i+1, cnt+1);
			select[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행
		M = Integer.parseInt(st.nextToken());	// 열
		D = Integer.parseInt(st.nextToken());	// 궁수의 공격 거리 제한
		
		// 격자판 정보 입력
		map = new int[N+1][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// N+1행에 궁수 랜덤 배치
		copy = deepcopy(map);
		select = new boolean[M];
		combi(0, 0);
		
		System.out.println(maxAnswer);
	}
	
	// 2차원 배열 깊은복사
	public static int[][] deepcopy(int[][] arr){
		int[][] copy = new int[N+1][M];
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
}