import java.util.Scanner;
 
public class SWEA1210 {
    static int tc;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, direction = 0;
         
        int [][] map = new int[100][100];
         
        for(int t = 1; t <= 10; t++) {
            tc = sc.nextInt();
            for(int i = 0; i <100; i++) {
                for(int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                     
                    if(map[i][j] == 2) {
                        x = j;
                        y = i;
                        direction = 0;
                    }
                }
            }
            while (y != 0) {
                if(direction == 0) {
                    y--;
                    if(x - 1 > 0 && map[y][x - 1] == 1) {
                        direction = 1;
                    }else if(x + 1 < 100 && map[y][x + 1] == 1) {
                        direction = 2;
                    }
                }else if(direction == 1) {
                    x--;
                    if(map[y - 1][x] == 1) {
                        direction = 0;
                    }
                }else if(direction == 2) {
                    x++;
                    if(map[y - 1][x] == 1) {
                        direction = 0;
                    }
                }
            }
            System.out.println("#" + t + " " + x);
            System.out.println();
        }
    }
}