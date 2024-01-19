import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();		// 문자열
		String bump = br.readLine();	// 폭발 문자열
		
		int strLen = str.length();
		int bumpLen = bump.length();
		Stack<Character> s = new Stack<>();
		for(int i=0; i<strLen; i++) {
			s.push(str.charAt(i));
			// 스택에 들어온 문자열의 길이가 폭발문자열의 길이와 같아지면 탐색 시작
			boolean flag = false;
			if(s.size() >= bumpLen) {
				for(int j=0; j<bumpLen; j++) {
					if(s.get(s.size()-bumpLen+j) != bump.charAt(j)) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					for(int j=0; j<bumpLen; j++) {
						s.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(s.size() != 0) {
			for(Character c : s) {
				sb.append(c);
			}
		}else sb.append("FRULA");
		System.out.println(sb.toString());
	}
}