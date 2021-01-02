import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class SWEA1984 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int [] arr;
        for(int t = 1; t <= tc; t++) {
            String [] str = br.readLine().split(" ");
            arr = new int[str.length];
            for(int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            double sum = 0;
            for(int i = 1; i < arr.length -1; i++) {
                sum += arr[i];
            }
            double avg = sum / 8;
            int res = Integer.parseInt(String.valueOf(Math.round(avg)));
            System.out.print("#" + t + " " + res + "\n");
        }
        br.close();
    }
}