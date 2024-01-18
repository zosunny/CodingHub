import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char[] tmp;
		char[] pmt;
		while(true) {
			boolean flag = false;
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if(input.equals("0")) return;
			int len = input.length();
			tmp = new char[len];
			for(int i=0; i<len; i++) {
				tmp[i] = input.charAt(i);
			}
			pmt = new char[len];
			for(int i=len-1; i>=0; i--) {
				pmt[i] = input.charAt(Math.abs(len-i-1));
			}
			for(int i=0; i<len; i++) {
				if(tmp[i] != pmt[i]) {
					flag = true;
					break;
				}
			}
			if(flag) System.out.println("no");
			else System.out.println("yes");
		}
	}
}