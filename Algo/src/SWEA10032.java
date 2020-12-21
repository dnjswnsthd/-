import java.util.Scanner;
public class SWEA10032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            int snack = sc.nextInt();
            int person = sc.nextInt();
            if(snack % person == 0) System.out.println("#" + t + " 0");
            else System.out.println("#" + t + " 1");
        }       
    }
}