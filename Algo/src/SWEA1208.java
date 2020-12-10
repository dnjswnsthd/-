import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA1208 {
    static int max;
    static int min;
    static int[] cnt = new int[100 + 1];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            init();
            int[] height = new int[100];
            int d_no = sc.nextInt();
            for (int i = 0; i < height.length; i++)
                height[i] = sc.nextInt();
            count(height);
            dump(tc, d_no);
        }
    }
 
    public static void init() {
        max = 100;
        min = 1;
        Arrays.fill(cnt, 0);
    }
 
    public static void count(int[] box) {
        for (int i = 0; i < box.length; i++)
            cnt[box[i]]++;
    }
 
    public static void dump(int tc, int d_no) {
        for (int i = 0; i < d_no; i++) {
            if (max - min == 0 || max - min == 1)
                break;
            idx();
            cnt[max]--;
            cnt[max - 1]++;
            cnt[min]--;
            cnt[min + 1]++;
        }
        idx();
        System.out.println("#" + tc + " " + (max - min));
    }
 
    public static void idx() {
        while (cnt[max] == 0)
            max--;
        while (cnt[min] == 0)
            min++;
    }
}