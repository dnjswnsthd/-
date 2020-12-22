import java.util.Scanner;
public class SWEA9997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            System.out.println("#" + t + " " + n/30 + " " + n%30*2);
        }
    }
}