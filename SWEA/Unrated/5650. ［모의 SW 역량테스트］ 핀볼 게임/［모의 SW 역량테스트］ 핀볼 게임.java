import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	static int T;
	static int N;
	static int ans;
	static int maxAns;
	
	static int[][] arr;
	static Point[][] wh;
	static boolean[] flag;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	// 현재 방향에서 각 블럭을 만났을 때 변하는 방향
	static int[][] dir = {
			{2, 1, 3, 2, 2},
			{3, 3, 2, 0, 3},
			{1, 0, 0, 3, 0},
			{0, 2, 1, 1, 1}
			};
	
	public static int move(int x, int y, int d) {
		int startX = x;
		int startY = y;
		int score = 0;
		
		while(true) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 블랙홀이나 초기위치면 -> 종료
			if(arr[nx][ny]==-1 || (nx==startX && ny==startY)) return score;
			
			// 웜홀로 들어가면 -> 쌍인 웜홀로 위치만 변경
			else if(arr[nx][ny]>=6) {
				int next = arr[nx][ny];
				if(wh[0][next-6].x==nx && wh[0][next-6].y==ny) {
					nx = wh[1][next-6].x;
					ny = wh[1][next-6].y;
				}else {
					nx = wh[0][next-6].x;
					ny = wh[0][next-6].y;
				}
			}
			// 블럭을 만나면 -> 이동하지않고(부딪히고), 점수, 방향바뀜.
			else if(arr[nx][ny]!=0 && arr[nx][ny]<=5) {
				int next = arr[nx][ny];
				d = dir[d][next-1];
				score++;
			}
			// 그외 이동
			x = nx;
			y = ny;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			maxAns = Integer.MIN_VALUE;
			N = sc.nextInt();
			
			arr = new int[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==0 || i==N+1 || j==0 || j==N+1) {
						arr[i][j] = 5;
					}
				}
			}
			
			wh = new Point[2][5];
			flag = new boolean[5];	// 해당 웜홀이 이전에 값이 이미 들어갔는지 체크
			
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					arr[i][j] = sc.nextInt();
					// 웜홀 정보 배열
					if(arr[i][j]>=6) {
						int now = arr[i][j];
						if(!flag[now-6]) {
							wh[0][now-6] = new Point(i, j);
							flag[now-6] = true;
						}else {
							wh[1][now-6] = new Point(i, j);
						}
					}
				}
			}

			// 각 핀볼의 위치에서, 4방향에서 출발해보기
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j]==0) {
						for(int d=0; d<4; d++) {
							ans = move(i, j, d);
							maxAns = Math.max(maxAns, ans);
						}
					}
				}
			}
			sb.append("#" + (t+1) + " " + maxAns + "\n");
		}
		System.out.println(sb.toString());
	}
}