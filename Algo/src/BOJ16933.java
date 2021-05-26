import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ16933 {
    static int n, m, k;
    static int dy[] = { 0, 0, 1, -1 };
    static int dx[] = { 1, -1, 0, 0 };
    static char map[][];
    static boolean visit[][][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
 
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit = new boolean[n][m][k + 1][2];
 
        visit[0][0][0][0] = true;
        Queue<Pair3> q = new LinkedList<>();
        q.add(new Pair3(0, 0, 0, 0));
        int ans = -1;
        int time = 1;
 
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair3 cur = q.poll();
                if (cur.y == n - 1 && cur.x == m - 1) {
                    ans = time;
                    break;
                }
                // 가만히 있기
                if (!visit[cur.y][cur.x][cur.k][(cur.dayNight + 1) % 2]) {
                    visit[cur.y][cur.x][cur.k][(cur.dayNight + 1) % 2] = true;
                    q.add(new Pair3(cur.y, cur.x, cur.k, (cur.dayNight + 1) % 2));
                }
 
                // 이동하기
                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if (arrange_chk(ny, nx)) {
 
                        if (map[ny][nx] == '1' && cur.dayNight == 0) {
                            if (cur.k == k)
                                continue;
                            if (!visit[ny][nx][cur.k + 1][1]) {
                                visit[ny][nx][cur.k + 1][1] = true;
                                q.add(new Pair3(ny, nx, cur.k + 1, 1));
                            }
                        } else if (map[ny][nx] == '0') {
                            if (!visit[ny][nx][cur.k][(cur.dayNight + 1) % 2]) {
                                visit[ny][nx][cur.k][(cur.dayNight + 1) % 2] = true;
                                q.add(new Pair3(ny, nx, cur.k, (cur.dayNight + 1) % 2));
                            }
                        }
                    }
                }
            }
 
            if (ans != -1) {
                break;
            }
 
            time++;
        }
        System.out.println(ans);
    }
    static boolean arrange_chk(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= m)
            return false;
        return true;
    }
}

class Pair3 {
    int y;
    int x;
    int k;
    int dayNight;

    public Pair3(int y, int x, int k, int dayNight) {
        super();
        this.y = y;
        this.x = x;
        this.k = k;
        this.dayNight = dayNight;
    }
}