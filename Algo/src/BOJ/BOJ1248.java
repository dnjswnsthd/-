package BOJ;

import java.util.Scanner;

public class BOJ1248 {
    static int N;
    static char[][] matrix;
    static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new char[N][N];
        String str = sc.next();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                matrix[i][j] = str.charAt(idx++);
            }
        }
        data = new int[N];
        sol(0);
    }
    private static void sol(int depth) {
        if (depth == N) {
            for (int i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.exit(0);
        }
        for (int i = -10; i <= 10; i++) {
            data[depth] = i;
            if (chk(depth)) {
            	sol(depth + 1);
            }
        }
    }
    private static boolean chk(int idx) {
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += data[j];
                if (matrix[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
                    return false;
                }
            }
        }
        return true;
    }
}