import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        for(int i=0; i<8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String origin = "";
        for(int i=0; i<8; i++){
            origin += arr[i];
        }

        Arrays.sort(arr);
        String asc = "";
        for(int i=0; i<8; i++){
            asc += arr[i];
        }

        if(origin.equals(asc)) {
            System.out.println("ascending");
            return;
        }

        Arrays.sort(arr);
        String desc = "";
        for(int i=7; i>=0; i--){
            desc += arr[i];
        }

        if(origin.equals(desc)) {
            System.out.println("descending");
            return;
        }

        System.out.println("mixed");
    }
}