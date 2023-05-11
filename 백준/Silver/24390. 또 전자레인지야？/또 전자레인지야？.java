import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int sec = 10;
	static final int min = 60;
	static final int tenMin = 600;
	static final int start = 30;
	static int M;
	static int S;
	static int MS;
	static int ans;
	
	public static void calc() {
		ans += MS / tenMin;		// 10분 버튼 몇번?
		MS %= tenMin;			// 10분 버튼 누르고 남은 시간
		ans += MS / min;		// 1분 버튼 몇번?
		MS %= min;				// 1분 버튼 누르고 남은 시간
		if(MS > 30) {			// 30초 이상으로 남았을 때
			MS -= 30;			// 시작 버튼으로 누를 30초 빼고
			ans += MS / sec;	// 10초 버튼 몇번?
			MS %= sec;			// 10초 버튼 누르고 남은 시간ㄴ
		}else if(MS < 30) {		// 30초 이하로 남았을 때
			ans += MS / sec;	// 10초 버튼 몇번?
		}
			ans += 1;			// 시작 버튼 누르는 경우
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		M = Integer.parseInt(st.nextToken());	// 분
		S = Integer.parseInt(st.nextToken());	// 시
		MS = M * 60 + S;
		calc();
		System.out.println(ans);
	}
}