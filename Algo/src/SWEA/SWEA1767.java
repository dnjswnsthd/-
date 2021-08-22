package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class SWEA1767 {
    static int size, core_no;
    static int[][] map;
    static int[][] core = new int[12][2];
    static int res_cpu;
    static long res_len;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            res_cpu = -1;
            res_len = 0;
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            core_no = 0;
            for (int j = 0; j < size; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < size; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value != 0) {
                        map[j][k] = 1;
                        core[core_no][0] = j;
                        core[core_no][1] = k;
                        core_no += 1;
                    }
                }
            } 
            dfs(0, 0, 0);
            System.out.println("#" + t + " " + res_len);
        }
    }
    static void dfs(int now, int num, long tmp) {
        if (now == core_no) {
            if (res_cpu == -1) {
                res_cpu = num;
                res_len = tmp;
            } else if (res_cpu < num) {
                res_cpu = num;
                res_len = tmp;
            } else if (res_cpu == num && res_len > tmp) {
                res_len = tmp;
            }
            return;
        }
        int nowy = core[now][0];
        int nowx = core[now][1];
        if ( nowx == 0 || nowx == size - 1 || nowy == 0 || nowy == size - 1 ) { 
            dfs(now + 1, num + 1, tmp);
        } else {
            // 위쪽
            boolean isPossible = true;
            for (int i = nowy - 1; i >= 0; i--) {
                if (map[i][nowx] != 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                for (int i = nowy - 1; i >= 0; i--) {
                    map[i][nowx] = 1;
                }
                dfs(now + 1, num + 1, tmp + nowy);
                for (int i = nowy - 1; i >= 0; i--) {
                    map[i][nowx] = 0;
                }
            }
            // 아래쪽
            isPossible = true;
            for (int i = nowy + 1; i < size; i++) {
                if (map[i][nowx] != 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                for (int i = nowy + 1; i < size; i++) {
                    map[i][nowx] = 1;
                }
                dfs(now + 1, num + 1, tmp + (size - 1 - nowy));
                for (int i = nowy + 1; i < size; i++) {
                    map[i][nowx] = 0;
                }
            }
            // 왼쪽
            isPossible = true;
            for (int i = nowx - 1; i >= 0; i--) {
                if (map[nowy][i] != 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                for (int i = nowx - 1; i >= 0; i--) {
                    map[nowy][i] = 1;
                }
                dfs(now + 1, num + 1, tmp + nowx);
                for (int i = nowx - 1; i >= 0; i--) {
                    map[nowy][i] = 0;
                }
            }
            // 오른쪽
            isPossible = true;
            for (int i = nowx + 1; i < size; i++) {
                if (map[nowy][i] != 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                for (int i = nowx + 1; i < size; i++) {
                    map[nowy][i] = 1;
                }
                dfs(now + 1, num + 1, tmp + (size - 1 - nowx));
                for (int i = nowx + 1; i < size; i++) {
                    map[nowy][i] = 0;
                }
            }
            dfs(now + 1, num, tmp);
        }
    }
}