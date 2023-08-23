import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	
	static Deque<Character> left;
	static Deque<Character> right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		left = new ArrayDeque<>();
		right = new ArrayDeque<>();
		for(int i=0; i<s.length(); i++) {
			left.add(s.charAt(i));
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			char order = st.nextToken().charAt(0);
			
			if(order == 'L') {
				if(left.size() != 0) {
					right.addFirst(left.pollLast());
				}
			}else if(order == 'D') {
				if(right.size() != 0) {
					left.add(right.pollFirst());
				}
			}else if(order == 'B') {
				if(left.size() != 0) {
					left.pollLast();
				}
			}else if(order == 'P') {
				char letter = st.nextToken().charAt(0);
				left.add(letter);
			}
		}
		while(!left.isEmpty()) {
			sb.append(left.pollFirst());
		}
		while(!right.isEmpty()) {
			sb.append(right.pollFirst());
		}
		System.out.println(sb.toString());
	}
}