package SWEA;

import java.util.Scanner;
public class SWEA1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int mok = i/10; 
            int rem = i%10;
            if (mok == 3 || mok == 6 || mok == 9) {
                if (rem == 3 || rem == 6 || rem == 9) {
                    System.out.print("-- ");
                    continue;
                }
                System.out.print("- ");
            }
            else if (rem == 3 || rem == 6 || rem == 9)
                System.out.print("- ");
            else {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}