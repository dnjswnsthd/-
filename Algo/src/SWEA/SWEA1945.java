package SWEA;

import java.util.Scanner;
 
public class SWEA1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] res = {0, 0, 0, 0, 0};
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
             
            while(true) {
                if(n % 11 == 0) {
                    n = n / 11; 
                    res[4]++;
                }
                else break;
            }
            while(true) {
                if(n % 7 == 0) {
                    n = n / 7; 
                    res[3]++;
                }
                else break;
            }
            while(true) {
                if(n % 5 == 0) {
                    n = n / 5; 
                    res[2]++;
                }
                else break;
            }
            while(true) {
                if(n % 3 == 0) {
                    n = n / 3; 
                    res[1]++;
                }
                else break;
            }
            while(true) {
                if(n % 2 == 0) {
                    n = n / 2; 
                    res[0]++;
                }
                else break;
            }
             
            System.out.println("#" + t + " " + res[0] + " " + res[1] + " " + res[2] + " " + res[3] + " " +  res[4]);
            for(int i = 0; i < 5; i++) {
                res[i] = 0;
            }
        }
         
         
    }
}