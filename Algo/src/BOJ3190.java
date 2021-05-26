import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//1. ���� �Ӹ��� ������ �̵��Ѵ�.
//2. ���� �Ӹ��� �ִ� ���� ����� ������ ���� ��ġ�� ����
//3. ���� �Ӹ��� �ִ� ���� ����� ������ ���� �ڸ�
//4. ���� �Ӹ��� �ִ� ���� ���̳� ���� ���� ������ ������ ����.
class Main {
    private static int n, k, l;
    private static int[][] map;
    private static int[] time_arr;
    private static int[] dir;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Deque <Pair> snake = new ArrayDeque<Pair>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];    // �� �� �� ������ (1,1)
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;    // ��� ��ġ�� 1
        }
        l = Integer.parseInt(br.readLine());
        time_arr = new int[l];
        dir = new int[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time_arr[i] = Integer.parseInt(st.nextToken());
            dir[i] = Dir(st.nextToken());
        }
        sol();
    }
    static void sol() {
        int second = 0;
        int snake_dir = 1;    // ù ������ ������
        int time = 0;
        map[1][1] = 2;  // ó�� ���� ��ġ�� (1,1)
        snake.add(new Pair(1, 1));
        while (true) {
            // �ð��� ������ ���� �ٲٱ�
            if (time < l && time_arr[time] == second) {
            	snake_dir = (snake_dir + dir[time]) % 4;
            	time++;
            }
            // 1. �����̸� �÷� �Ӹ��� ���� ĭ�� ��ġ��Ų��
            int nx = snake.getFirst().x + dx[snake_dir];
            int ny = snake.getFirst().y + dy[snake_dir];
            // ���̳� ���� �ε����� ���� ��
            if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
                System.out.println(second + 1);
                break;
            }
            if (map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }
            if (map[nx][ny] == 1) {
                // 2. ���� �̵��� ĭ�� ����� ������, ��� �������� ���� �״�� �Ӹ� �߰�
                map[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));
            }
            else if (map[nx][ny] == 0) {
                // 3. ���� �̵��� ĭ�� ����� ���ٸ�, �����̸� �ٿ� ������ ��ġ�� ĭ ����
                map[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));
                Pair tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            second++;
        }
    }
    // �������� (���� ���� + 1) % 4 ������ (���� ���� + 3) % 4
    static int Dir(String s) {
        if (s.equals("D"))
            return 1;
        else
            return 3;
    }
    static int pair(String s) {
        return Integer.parseInt(s);
    }
    static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}