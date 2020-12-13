import java.util.*;
 
public class SWEA1873 {
    static int w, h, x, y , dx, dy;
    static char[][] field;
     
    //문자에 따라서 방향 설정
    public static void dir_set(char c, int i, int j) {
        if(c == '^') {
            dx = -1; dy = 0;
            x = i; y = j;
        }else if(c == 'v') {
            dx = 1; dy = 0;
            x = i; y = j;
        }
        else if(c == '<') {
            dx = 0; dy = -1;
            x = i; y = j;
        }
        else if(c == '>') {
            dx = 0; dy = 1;
            x = i; y = j;
        }
    }
    //명령에 따른 동작실행
    public static void order(char com) {
        if(com == 'S') {
            int nx = x;
            int ny = y;
            while(nx + dx >= 0 && nx + dx < h && ny + dy >= 0 && ny + dy < w) {
                if(field[nx + dx][ny + dy] == '*') {
                    field[nx + dx][ny + dy] = '.';
                    break;
                }else if(field[nx + dx][ny + dy] == '#') {
                    break;
                }
                nx += dx;
                ny += dy;
            }
        }else {
            if(com == 'U') {
                dx = -1;
                dy = 0;
                field[x][y] = '^';
            }else if(com == 'D') {
                dx = 1;
                dy = 0;
                field[x][y] = 'v';
                 
            }else if(com == 'L') {
                dx = 0;
                dy = -1;
                field[x][y] = '<';
            }else if(com == 'R') {
                dx = 0;
                dy = 1;
                field[x][y] = '>';
            }
            int nx = x + dx;
            int ny = y + dy;
            if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if(field[nx][ny] == '.') {
                    field[nx][ny] = field[x][y];
                    field[x][y] = '.';
                    x += dx;
                    y += dy;
                }
                 
            }
        }
         
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            h = sc.nextInt();
            w = sc.nextInt();
            dx = 0; dy = 0;
            x = 0; y = 0;
             
            field = new char[h][w];
             
            for(int i = 0; i < h; i++) {
                String str = sc.next();
                for(int j = 0; j < w; j++) {
                    field[i][j] = str.charAt(j);
                    dir_set(field[i][j], i, j);
                }
            }
             
            int n = sc.nextInt();
            String str = sc.next();
             
            for(int i = 0; i < n; i++) {
                char com = str.charAt(i);
                order(com);
            }
            System.out.print("#" + t + " ");
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
             
        }
        sc.close();
    }
}