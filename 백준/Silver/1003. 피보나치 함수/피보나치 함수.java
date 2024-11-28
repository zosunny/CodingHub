import java.util.Scanner;

public class Main {
	
	static int T;
	static int N;
	static int cnt0;
	static int cnt1;
	
	static int[] zeroList;
	static int[] oneList;

	public static int fibo0(int N) {
		if(N == 0) {
			return 1;
		}
		else if(N == 1) {
			return 0;
		}
		else {
			if (zeroList[N] != 0) {
				return zeroList[N];
			}
			else return zeroList[N] = fibo0(N-1) + fibo0(N-2);
		}
	}
	
	public static int fibo1(int N) {
		if(N == 0) {
			return 0;
		}
		else if(N == 1) {
			return 1;
		}
		else {
			if (oneList[N] != 0) {
				return oneList[N];
			}
			else return oneList[N] = fibo1(N-1) + fibo1(N-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			cnt0 = 0;
			cnt1 = 0;
			N = sc.nextInt();
			zeroList = new int[N + 1];
			oneList = new int[N + 1];
			
			fibo0(N);
			fibo1(N);
			System.out.println(fibo0(N) + " " + fibo1(N));
		}
	}
}