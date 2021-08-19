// 프로그래머스 코딩테스트 연습 방문 길이
public class Pro_visitedDis {
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 5, y = 5, nx =5, ny = 5;
        for (int i = 0; i < dirs.length(); i++) {
            x = nx;
            y = ny;
            if (dirs.charAt(i) == 'U') {
                if(ny - 1 >= 0)
                    ny--;
                else
                    continue;
            } else if (dirs.charAt(i) == 'D') {
                if(ny + 1 < 11)
                    ny++;
                else
                    continue;
            } else if (dirs.charAt(i) == 'L') {
                if(nx - 1 >= 0)
                    nx--;
                else
                    continue;
            } else if (dirs.charAt(i) == 'R') {
                if(nx + 1 < 11)
                    nx++;
                else
                    continue;
            }
            if (!visited[x][y][nx][ny] && !visited[nx][ny][x][y]) {
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                System.out.println(nx + " " + ny);
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
}
