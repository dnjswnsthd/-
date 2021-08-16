import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 삼각 달팽이
public class Pro_triangleSnail {
    public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1) / 2)];
        int[][] snail = new int[n][n];
        int x = -1, y = 0;
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                }else if(i % 3 == 2){
                    x--;
                    y--;
                }
                snail[x][y] = tmp++;
            }
        }
        tmp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(snail[i][j] == 0) break;
                answer[tmp++] = snail[i][j];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(Arrays.toString(solution(n)));
    }
}
