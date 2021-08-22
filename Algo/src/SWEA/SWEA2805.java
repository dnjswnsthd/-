package SWEA;

import java.util.Scanner;
 
public class SWEA2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int sum = 0;
            //위쪽 부터 홀수의 중심이 되는 n/2+1까지의 합
            for (int i = n / 2; i >= 0; i--) {
                String s = sc.next();
                for (int j = i; j < n - i; j++) {
                    sum += s.charAt(j) - '0';
                }
            }
            //홀수의 중심이 되는 n/2+1아래부터  n까지의 합
            for (int i = 1; i <= n / 2; i++) {
                String s = sc.next();
                for (int j = i; j < n - i; j++) {
                    sum += s.charAt(j) - '0';
                }
            }
            System.out.println("#" + t + " " + sum);
        }
        sc.close();
    }
}