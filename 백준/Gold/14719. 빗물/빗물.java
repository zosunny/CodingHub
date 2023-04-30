import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int n, max;
		public Point(int n, int max) {
			super();
			this.n = n;
			this.max = max;
		}
	}
	
	static int H, W;
	static int mid;
	static int ans;
	static int maxTmp = Integer.MIN_VALUE;
	
	static int[] arr;
	static Stack<Point> block;
	
	
	public static void vol() {
		while(!block.isEmpty()) {
			Point p = block.pop();
			ans += p.max - p.n;
		}
	}
	
	public static void calc() {
		
		// 왼쪽부터 탐색
		for(int i=0; i<=mid; i++) {
			// 이전 블럭들보다 같거나 큰 블럭이면 물이 고일 거야
			if(arr[i]>=maxTmp) {
				// 고인 물 계산
				vol();
			}
			if(i==mid) break;
			//최댓값 갱신
			maxTmp = Math.max(maxTmp, arr[i]);
			// 스택에 계속 넣기
			block.add(new Point(arr[i], maxTmp));
		}
		
		maxTmp = Integer.MIN_VALUE;
		
		// 오른쪽 부터 탐색
		for(int i=W-1; i>=mid; i--) {
			// 이전 블럭들보다 같거나 큰 블럭이면 물이 고일 거야
			if(arr[i]>=maxTmp) {
				// 고인 물 계산
				vol();
			}
			if(i==mid) break;
			//최댓값 갱신
			maxTmp = Math.max(maxTmp, arr[i]);
			// 스택에 계속 넣기
			block.add(new Point(arr[i], maxTmp));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		block = new Stack<>();
		arr = new int[W];
		int tmp = Integer.MIN_VALUE;

		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(tmp < arr[i]) {
				mid = i;
				tmp = arr[i];
			}
		}
		
		calc();
		
		System.out.println(ans);
	}
}