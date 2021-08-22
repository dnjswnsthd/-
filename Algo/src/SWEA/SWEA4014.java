package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA4014 {
    private static int N, X, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            cnt = 0;
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int[][] r_map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    r_map[j][i] = map[i][j];
                }
            }
            start(map);
            start(r_map);
            sb.append("#" + t + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
    private static void start(int[][] map) {
        for (int i = 0; i < N; i++) {
            boolean chk = true;
            int equal = 1;
            for (int j = 1; j < N; j++) {
                if (map[i][j - 1] != map[i][j]) {
                    //내려감 
                    if (map[i][j - 1] == map[i][j] + 1) {
                        //경사로 마지막 칸으로 인덱스를 이동시키기 때문에 경사로를 만들면서 지금 칸의 높이가 변하게 되므로 0으로 초기화 해야함! 
                        equal = 0;
                        if (slp_chk(map, i, j, map[i][j])) {
                            j += X - 1;
                        } else {
                            chk = false;
                            break;
                        }
                    //올라감 
                    } else if (map[i][j - 1] == map[i][j] - 1) {
                        //equal >= X 면 올라오는 경사로를 만들 수 있다는 것이므로 별다른 작업 필요 없음
                        if (equal < X) {
                            chk = false;
                            equal = 1;
                            break;
                        }
                        equal = 1;
                    //경사로로 이을 수 없는 경우 (차이가 1이 아닌 경우) 
                    } else {
                        chk = false;
                        equal = 1;
                        break;
                    }
                } else {    //앞칸과 높이가 같은 경우 
                    equal++;
                }
            }
            if (chk) cnt++;
        }
    }
    //가로가 true, 세로가 false 
    private static boolean slp_chk (int[][] map, int x, int y, int height) {
        int k = 1;  //초기 경사로 길이는 1 
        while (y + k < N && map[x][y + k] == height && k < X) //배열 범위 안에서, 주어진 경사로 길이 안에서 그을 수 있는 경사로 길이 체크 
            k++;
        if (k == X) return true;
        else return false;
    }
}