import java.io.*;
import java.util.*;
 
public class SWEA5656 {
    public static final int[] dx = { 1, 0, -1, 0 };
    public static final int[] dy = { 0, 1, 0, -1 };
    public static int N, W, H, cnt, res;
    public static boolean[][] visit;
    public static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            res = Integer.MAX_VALUE;
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            visit = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0)
                        cnt++;
                }
            }
            drop(N, cnt, map);
            System.out.println("#" + t + " " + res);
        }
    }
    private static void drop(int r, int cnt, int[][] map) {
        if (r == 0) {
            res = Math.min(res, cnt);
            return;
        }
        for (int c = 0; c < W; c++) {
            // map 복제
            int[][] copyMap = copy(map);
            // 해당 컬럼의 맨 처음 벽돌 가져오기
            Pair first = getFirst(c, copyMap);
            // null --> continue;
            if (first == null)
                continue;
            // 구슬을 떨어뜨려서 벽돌을 깬다.
            int broken = del(first, copyMap);
            // 이미 벽돌 다 깨졌으면, res = 0
            if (broken >= cnt) {
                res = 0;
                return;
            }
            // 4. 맵 정리
            newMap(copyMap);
            // 5. 다음 샷 발사
            drop(r - 1, cnt - broken, copyMap);
        }
    }
    private static void newMap(int[][] map) {
        for (int c = 0; c < W; c++) {
            for (int r = H - 1, nr = H - 1; r >= 0; r--) {
                if (map[r][c] != 0) {
                    int tmp = map[r][c];
                    map[r][c] = 0;
                    map[nr--][c] = tmp;
                }
            }
        }
    }
    private static int del(Pair first, int[][] map) {
        int broken = 0;
        // 구슬 맞은 벽돌 삭제
        map[first.row][first.col] = 0;
        broken++;
        // 주변 벽돌 영향
        for (int p = 1; p < first.pow; p++) {
            // 4 방위 탐색
            for (int d = 0; d < 4; d++) {
                int nx = first.row + dx[d] * p;
                int ny = first.col + dy[d] * p;
                if (0 <= nx && 0 <= ny && nx < H && ny < W && map[nx][ny] != 0) {
                    broken += del(new Pair(nx, ny, map[nx][ny]), map);
                }
            }
        }
        return broken;
    }
    // 해당 col에 맨 처음 벽돌 가져간다 null이면 continue
    private static Pair getFirst(int c, int[][] map) {
        for (int r = 0; r < H; r++) {
            if (map[r][c] != 0) {
                return new Pair(r, c, map[r][c]);
            }
        }
        return null;
    }
    // map 복제
    private static int[][] copy(int[][] map) {
        int[][] tmp = new int[H][W];
        for (int i = 0; i < H; i++) {
            tmp[i] = map[i].clone();
        }
        return tmp;
    }
    static class Pair {
        int row, col, pow;
        public Pair(int row, int col, int pow) {
            this.row = row;
            this.col = col;
            this.pow = pow;
        }
    }
}