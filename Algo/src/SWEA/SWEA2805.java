package SWEA;

import java.util.Scanner;
 
public class SWEA2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int sum = 0;
            //���� ���� Ȧ���� �߽��� �Ǵ� n/2+1������ ��
            for (int i = n / 2; i >= 0; i--) {
                String s = sc.next();
                for (int j = i; j < n - i; j++) {
                    sum += s.charAt(j) - '0';
                }
            }
            //Ȧ���� �߽��� �Ǵ� n/2+1�Ʒ�����  n������ ��
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