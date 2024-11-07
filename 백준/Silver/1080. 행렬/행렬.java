import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int cnt;
    static char[][] arr1, arr2;

    public static boolean check(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }

    public static void reverse(){
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                // 해당 위치의 두 배열 값이 다르면 3x3 뒤집음
                if(arr1[i][j] != arr2[i][j]){
                    for(int k=i; k<i+3; k++){
                        for(int h=j; h<j+3; h++){
                            if(k>=n || h>=m) continue;
                            if(arr1[k][h] == '0') arr1[k][h] = '1';
                            else arr1[k][h] = '0';
                        }
                    }
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new char[n][m];
        arr2 = new char[n][m];
        for(int i=0; i<n; i++) arr1[i] = br.readLine().toCharArray();
        for(int i=0; i<n; i++) arr2[i] = br.readLine().toCharArray();
        if(check()) System.out.println(0);
        // 크기가 3 미만이면 -1
        else if(n<3 || m<3) System.out.println(-1);
        else{
            reverse();
            if(!check()) System.out.println(-1);
            else System.out.println(cnt);
        }
    }
}