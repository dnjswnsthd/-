package SWEA;

import java.util.Scanner;
 
public class SWEA1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int [] list;
        for (int t = 0; t < tc; t++) {
            int num = sc.nextInt();
            list = new int[num];
            for (int n = 0; n < num; n++) {
                list[n] = sc.nextInt();
            }
            long result = 0;
            long max = 0;
            int coinNum = 0;
            for (int j = num - 1; j >= 0; j--) {
                if (list[j] > max) {
                     
                    if (coinNum != 0) {
                        result = result + (coinNum * max);
                    }
                    max = list[j];
                    coinNum = 0;
 
                } else if (list[j] < max) {
                    coinNum++;
                    result = result - list[j];
                }
                 
                 
            }
            if (coinNum != 0) {    
                result = result + (coinNum * max);
            }
 
            System.out.printf("#%d %d\n", t+1, result);
        }
    }
}