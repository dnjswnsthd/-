import java.util.Arrays;
// 프로그래머스 코딩 테스트 연습 행렬의 덧셈
public class Pro_arrAdd {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2,3 }, { 2, 1,4 } };
        int[][] arr2 = { { 4, 6,3 }, { 7, 9,1 } };
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }
}
