import java.util.Arrays;
import java.util.Scanner;
public class SWEA7829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int [] arr;
        for(int t = 1; t <= tc ; t++) {
            int n = sc.nextInt();
            arr = new int[n];
            for(int i = 0 ; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int res = arr[0] * arr[arr.length-1];
            System.out.println("#" + t + " " + res);
        }
        sc.close();
    }
}