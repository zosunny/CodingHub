import java.util.Scanner;

public class Main {
	
	static int N;
	static int cnt;
	
	static int[] col;
	
	public static boolean available(int row) {
		for(int i=1; i<row; i++) {
			if(col[i]==col[row] || Math.abs(col[i]-col[row])==row-i) {
				return false;
			}
		}
		return true;
	}
	
	public static void set(int row) {
		// 이전까지의 퀸 유망성 체크 필요
		if(!available(row-1)) return;
		
		// 기저조건
		if(row == N+1) {
			cnt++;
			return;
		}
		
		// 모든 열에 대해 넣어보고 재귀돌며 적합성을 판별
		for(int i=1; i<N+1; i++) {
			col[row] = i;			// 현재 들어온 행의 퀸에 열은 1~N 중에 넣어보고 재귀를 통해 적합한 위치에 들어감
			set(row+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];
		
		set(1);	// 0은 그냥 두고 1넣고 이전 퀸의 유망성 체크
		
		System.out.println(cnt);
	}
}