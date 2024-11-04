import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        while(true){
            if(b == a) break;
            if(b < a) {
                cnt = -2;
                break;
            }
            String strB = Integer.toString(b);
            int len = strB.length();
            if(strB.charAt(len-1) == '1') {
                cnt++;
                strB = strB.substring(0, len-1);
                b = Integer.parseInt(strB);
            }else if(b % 2 == 0){
                cnt++;
                b = b / 2;
            }else {
                cnt = -2;
                break;
            }
        }
        System.out.println(cnt+1);
    }
}