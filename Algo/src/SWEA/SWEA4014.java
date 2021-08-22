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
                    //������ 
                    if (map[i][j - 1] == map[i][j] + 1) {
                        //���� ������ ĭ���� �ε����� �̵���Ű�� ������ ���θ� ����鼭 ���� ĭ�� ���̰� ���ϰ� �ǹǷ� 0���� �ʱ�ȭ �ؾ���! 
                        equal = 0;
                        if (slp_chk(map, i, j, map[i][j])) {
                            j += X - 1;
                        } else {
                            chk = false;
                            break;
                        }
                    //�ö� 
                    } else if (map[i][j - 1] == map[i][j] - 1) {
                        //equal >= X �� �ö���� ���θ� ���� �� �ִٴ� ���̹Ƿ� ���ٸ� �۾� �ʿ� ����
                        if (equal < X) {
                            chk = false;
                            equal = 1;
                            break;
                        }
                        equal = 1;
                    //���η� ���� �� ���� ��� (���̰� 1�� �ƴ� ���) 
                    } else {
                        chk = false;
                        equal = 1;
                        break;
                    }
                } else {    //��ĭ�� ���̰� ���� ��� 
                    equal++;
                }
            }
            if (chk) cnt++;
        }
    }
    //���ΰ� true, ���ΰ� false 
    private static boolean slp_chk (int[][] map, int x, int y, int height) {
        int k = 1;  //�ʱ� ���� ���̴� 1 
        while (y + k < N && map[x][y + k] == height && k < X) //�迭 ���� �ȿ���, �־��� ���� ���� �ȿ��� ���� �� �ִ� ���� ���� üũ 
            k++;
        if (k == X) return true;
        else return false;
    }
}