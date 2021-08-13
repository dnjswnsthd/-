import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 땅따먹기

public class Pro_eatTheGround {
    public static int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }
        Arrays.sort(land[land.length - 1]);
        return land[land.length-1][3];
    }

    private static int max(int i, int j, int k) {
        int max = Math.max(i, j);
        max = Math.max(max, k);
        return max;
    }

    public static void main(String[] args) {
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(solution(land));
    }
}
