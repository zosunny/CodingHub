import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long[] arr;	// 건물 높이
	static long answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			float a = 0;
			long now = arr[i];
			// 왼쪽 탐색
			if(i-1 >= 0) {
				a = now - arr[i-1];
				cnt++;
			}
			for(int m=i-2; m>=0; m--) {
				float na = (float)(now - arr[m]) / (float)(i - m);
				if(na < a) {
					cnt++;
					a = na;
				}
			}
			// 오른쪽 탐색
			if(i+1 < N) {
				a = arr[i+1] - now;
				cnt++;
			}
			for(int n=i+2; n<N; n++) {
				float na = (float)(arr[n] - now) / (float)(n - i);
				if(na > a) {
					cnt++;
					a = na;
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}