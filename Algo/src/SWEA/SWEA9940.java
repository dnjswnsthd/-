package SWEA;

import java.util.Arrays;
import java.util.Scanner;
public class SWEA9940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int [] tmp;
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            tmp = new int[n];
            for(int i = 0; i < n; i++) tmp[i] = sc.nextInt();
            Arrays.sort(tmp);
            int tmp_y = 0;
            for(int i = 0; i < n; i++) {
                if(tmp[i] != i+1) {break;}
                else {tmp_y++;}
            }
            if(tmp_y == n) System.out.println("#" + t + " Yes");
            else System.out.println("#" + t + " No");
        }
        sc.close();
    }
}