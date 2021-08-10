import java.util.ArrayList;
import java.util.Arrays;

//프로그래머스 코딩테스트 연습 카카오프렌즈 컬러링북

public class Pro_kakaoColor {
    static int[][] visited;
    static ArrayList<Integer> size;
    static int cnt, max;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static int[] solution(int m, int n, int[][] picture) {
        visited = new int[m][n];
        size = new ArrayList<>();
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && visited[i][j] == 0) {
                    cnt = 1;
                    dfs(i, j, m, n, picture);
                    max = Math.max(max, cnt);
                    size.add(cnt);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = size.size();
        answer[1] = max;
        return answer;
    }
    
    private static void dfs(int i, int j, int m, int n, int[][] picture) {
        visited[i][j] = picture[i][j];
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] != 0)
                continue;
            if (picture[nx][ny] == picture[i][j]) {
                cnt++;
                dfs(nx, ny, m, n, picture);
            }
        }
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        System.out.println(Arrays.toString(solution(m, n, picture)));
    }
}
