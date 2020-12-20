import java.util.Scanner;
 
public class SWEA3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int tmp_f = 0, tmp_s = 0;
            if (n % 2 == 1) {
                tmp_f = n / 2 + 1;
                tmp_s = n / 2;
            } else {
                tmp_f = n / 2;
                tmp_s = n / 2;
            }
            String[] arr1 = new String[tmp_f];
            String[] arr2 = new String[tmp_s];
            for (int i = 0; i < tmp_f; i++) {
                arr1[i] = sc.next();
            }
            for (int i = 0; i < tmp_s; i++) {
                arr2[i] = sc.next();
            }
 
            String[] arr3 = new String[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr3[i] = arr1[i / 2];
                } else {
                    arr3[i] = arr2[i / 2];
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr3[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}