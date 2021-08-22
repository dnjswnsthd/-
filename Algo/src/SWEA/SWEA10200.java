package SWEA;

import java.util.Scanner;
 
public class SWEA10200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(n >= a + b) {
                int min = 0;
                if (a>b) min = b;
                else min = a;
                System.out.println("#" + t + " " + min + " " + 0);
            }else {
                int tmp = a+b-n;
                int min = 0;
                if (a>b) min = b;
                else min = a;
                System.out.println("#" + t + " " + min + " " + tmp);
            }
        }
        sc.close();
    }
}