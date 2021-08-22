package SWEA;

import java.util.*;
 
public class SWEA1220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 2) {
                        arr[i][j] = 0;
                    }
                    if (arr[i][j] == 1) {
                        break;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i >= 0; i--) {
                    if (arr[i][j] == 1) {
                        arr[i][j] = 0;
                    }
                    if (arr[i][j] == 2) {
                        break;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                int count = 0;
                int state = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 1) {
                        state = 1;
                    } else if (arr[i][j] == 2) {
                        if (state == 1) {
                            count++;
                            state = 2;
                        }
                    }
                }
                res += count;
            }
            System.out.println("#" + t + " " + res);
        }
        sc.close();
    }
}