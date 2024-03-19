import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int minCnt = Integer.MAX_VALUE;
	
	static String[][] arr;
	static ArrayList<Point> cctv;
	
	static int[] dx = {0, -1, 0, 1};	// 왼, 위, 오, 아래
	static int[] dy = {-1, 0, 1, 0};
	
	// 사각 지대의 최소 크기를 카운트하는 함수
	public static void count(String[][] arr) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j].equals("0")) cnt++;
			}
		}
		minCnt = Math.min(minCnt, cnt);
	}
	
	// 각 cctv마다 90도씩 돌려가며 재귀탈거야
	public static void combi(int cnt, String[][] arr) {
		// 마지막 CCTV까지 "#"으로 만들어줬으면 사각 지대 크기 카운트 해보자
		if(cnt == cctv.size()) {
//			print(arr);
//			System.out.println("----------");
			count(arr);
			return;
		}
		// 현재 리스트에서 나온 CCTV가 몇번인지 확인
		int x = cctv.get(cnt).x;
		int y = cctv.get(cnt).y;
		String nowCCTV = arr[x][y];
		// 1번 CCTV는 상하좌우 다 한번씩 볼 수 있음
		if(nowCCTV.equals("1")) {
			for(int i=0; i<4; i++) {
				// 원본 카피 떠놓고
				String[][] copy1 = deepCopy(arr);
				int originX = x;
				int originY = y;
				// i방향으로 다 "#" 만들어
				while(true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny].equals("6")) break;
					if(arr[nx][ny].equals("0")) {
						copy1[nx][ny] = "#";
					}
					x = nx;
					y = ny;
				}
				// 다음 CCTV 꺼내
				combi(cnt+1, copy1);
				x = originX;
				y = originY;
			}
		}else if(nowCCTV.equals("2")) {
			for(int i=0; i<2; i++) {
				// 원본 카피 떠놓고
				String[][] copy2 = deepCopy(arr);
				int originX = x;
				int originY = y;
				for(int j=i; j<i+3; j+=2) {
					// i, i+2방향으로 다 "#" 만들어
					while(true) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny].equals("6")) break;
						if(arr[nx][ny].equals("0")) {
							copy2[nx][ny] = "#";
						}
						x = nx;
						y = ny;
					}
					x = originX;
					y = originY;
				}
				// 다음 CCTV 꺼내
				combi(cnt+1, copy2);
				x = originX;
				y = originY;
			}
		}else if(nowCCTV.equals("3")) {
			for(int i=0; i<4; i++) {
				// 원본 카피 떠놓고
				String[][] copy3 = deepCopy(arr);
				int originX = x;
				int originY = y;
				for(int j=i; j<i+2; j++) {
					// i, i+1 방향으로 다 "#" 만들어
					while(true) {
						int nx = x + dx[j%4];
						int ny = y + dy[j%4];
						if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny].equals("6")) break;
						if(arr[nx][ny].equals("0")) {
							copy3[nx][ny] = "#";
						}
						x = nx;
						y = ny;
					}
					x = originX;
					y = originY;
				}
				// 다음 CCTV 꺼내
				combi(cnt+1, copy3);
				x = originX;
				y = originY;
			}
		}else if(nowCCTV.equals("4")) {
			for(int i=0; i<4; i++) {
				// 원본 카피 떠놓고
				String[][] copy4 = deepCopy(arr);
				int originX = x;
				int originY = y;
				for(int j=i; j<i+3; j++) {
					// i, i+1, i+2 방향으로 다 "#" 만들어
					while(true) {
						int nx = x + dx[j%4];
						int ny = y + dy[j%4];
						if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny].equals("6")) break;
						if(arr[nx][ny].equals("0")) {
							copy4[nx][ny] = "#";
						}
						x = nx;
						y = ny;
					}
					x = originX;
					y = originY;
				}
				// 다음 CCTV 꺼내
				combi(cnt+1, copy4);
				x = originX;
				y = originY;
			}
		}else if(nowCCTV.equals("5")) {
			// 원본 카피 떠놓고
			String[][] copy5 = deepCopy(arr);
			int originX = x;
			int originY = y;
			for(int i=0; i<4; i++) {
				// 모든 방향으로 다 "#" 만들어
				while(true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny].equals("6")) break;
					if(arr[nx][ny].equals("0")) {
						copy5[nx][ny] = "#";
					}
					x = nx;
					y = ny;
				}
				x = originX;
				y = originY;
			}
			// 다음 CCTV 꺼내
			combi(cnt+1, copy5);
			x = originX;
			y = originY;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N][M];
		cctv = new ArrayList<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = st.nextToken();
				// cctv의 좌표만 리스트에 담아
				if(!arr[i][j].equals("0") && !arr[i][j].equals("6")) {
					cctv.add(new Point(i, j));
				}
			}
		}
		combi(0, arr);
		
		System.out.println(minCnt);
	}
	
	public static String[][] deepCopy(String[][] arr){
		String[][] copy = new String[arr.length][arr[0].length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	
	// 디버깅용
	public static void print(String[][] arr) {
		for(String[] r : arr) {
			for(String c : r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
