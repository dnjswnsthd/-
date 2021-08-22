package SWEA;

import java.util.Scanner;
 
public class SWEA1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int d = 1, x = 0, y = -1, cnt = 1;
             
             
            while(true) {
                for(int i = 0; i < n; i++) {
                    y = y + d;
                    map[x][y] = cnt;
                    cnt++;
                }
                n--;
                for(int i = 0; i < n; i++) {
                    x = x + d;
                    map[x][y] = cnt;
                    cnt++;
                }
                d *= -1;
                if(n == 0)
                    break;
            }
            System.out.println("#" + (t+1));
             
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}