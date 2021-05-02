import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//1. 뱀의 머리는 무조건 이동한다.
//2. 뱀의 머리가 있는 곳에 사과가 있으면 꼬리 위치는 유지
//3. 뱀의 머리가 있는 곳에 사과가 없으면 꼬리 자름
//4. 뱀의 머리가 있는 곳에 벽이나 뱀의 몸이 있으면 게임이 끝남.
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
        map = new int[n + 1][n + 1];    // 맨 위 맨 좌측은 (1,1)
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;    // 사과 위치는 1
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
        int snake_dir = 1;    // 첫 방향은 오른쪽
        int time = 0;
        map[1][1] = 2;  // 처음 뱀의 위치는 (1,1)
        snake.add(new Pair(1, 1));
        while (true) {
            // 시간이 지나면 방향 바꾸기
            if (time < l && time_arr[time] == second) {
            	snake_dir = (snake_dir + dir[time]) % 4;
            	time++;
            }
            // 1. 몸길이를 늘려 머리를 다음 칸에 위치시킨다
            int nx = snake.getFirst().x + dx[snake_dir];
            int ny = snake.getFirst().y + dy[snake_dir];
            // 몸이나 벽과 부딪히면 게임 끝
            if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
                System.out.println(second + 1);
                break;
            }
            if (map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }
            if (map[nx][ny] == 1) {
                // 2. 만약 이동한 칸에 사과가 있으면, 사과 없어지고 꼬리 그대로 머리 추가
                map[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));
            }
            else if (map[nx][ny] == 0) {
                // 3. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸 비우기
                map[nx][ny] = 2;
                snake.addFirst(new Pair(nx, ny));
                Pair tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            second++;
        }
    }
    // 오른쪽은 (현재 방향 + 1) % 4 왼쪽은 (현재 방향 + 3) % 4
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