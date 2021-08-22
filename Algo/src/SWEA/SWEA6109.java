package SWEA;

import java.io.*;
import java.util.*;
public class SWEA6109{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String oper = st.nextToken();
            int map[][] = new int[n][n];
            boolean visited[][] = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            switch(oper) {
            case "up":
                for(int i = 1; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        int di = i;
                        int tmp = map[i][j];
                        map[i][j] = 0;
                        while(di > 0 && map[di-1][j] == 0) --di;
                        if(di > 0 && map[di-1][j] == tmp && !visited[di-1][j]) {
                            visited[di-1][j] = true;
                            map[di-1][j] *= 2;
                        }else map[di][j] = tmp;
                    }
                }
                break;
            case "down":
                for(int i = n  -2; i >= 0; i--) {
                    for(int j = 0; j < n; j++) {
                        int di = i;
                        int tmp = map[i][j];
                        map[i][j] = 0;
                        while(di < n-1 && map[di+1][j] == 0) ++di;
                        if(di < n-1 && map[di+1][j] == tmp && !visited[di+1][j]) {
                            visited[di+1][j] = true;
                            map[di+1][j] *= 2;
                        }else map[di][j] = tmp;
                    }
                }
                break;
            case "left":
                for(int i = 1; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        int di = i;
                        int tmp = map[j][i];
                        map[j][i] = 0;
                        while(di > 0 && map[j][di-1] == 0) --di;
                        if(di > 0 && map[j][di-1] == tmp && !visited[j][di-1]) {
                            visited[j][di-1] = true;
                            map[j][di-1] *= 2;
                        }else map[j][di] = tmp;
                    }
                }
                break;
            case "right":
                for(int i = n - 2; i >= 0; i--) {
                    for(int j = 0; j < n; j++) {
                        int di = i;
                        int tmp = map[j][i];
                        map[j][i] = 0;
                        while(di < n - 1 && map[j][di+1] == 0) ++di;
                        if(di < n - 1 && map[j][di+1] == tmp&&!visited[j][di+1]) {
                            visited[j][di+1] = true;
                            map[j][di+1] *= 2;
                        }
                        else map[j][di] = tmp;
                    }
                }
                break;
            }
            System.out.println("#"+t);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}