package SWEA;

import java.util.Scanner;
public class SWEA6958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] arr = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            int [] sum = new int[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 1) sum[i] ++;
                }
                if(max < sum[i]) max = sum[i];
            }
            int res = 0;
            for(int i = 0; i < n; i++) {
                if(sum[i] == max) {
                    res++;
                }
            }
            System.out.println("#" + t + " " + res + " " + max);
             
        }
        sc.close();
    }
}