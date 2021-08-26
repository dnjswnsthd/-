package Programmers_level1_2;

import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 쿼드압축 후 개수 세기
public class Pro_quad {
    static int[] answer;
	public static int[] solution(int[][] arr) {
		answer = new int[2];
		quad(arr.length, 0, 0, arr);
		return answer;
	}
	public static void quad(int n, int x, int y, int[][] arr) {
		if(n == 1) {
			answer[arr[x][y]]++;
			return;
		}
        if (isBlock(n, x, y, arr))
            return;
        quad(n / 2, x, y, arr);
        quad(n / 2, x + n / 2, y, arr);
        quad(n / 2, x, y + n / 2, arr);
        quad(n / 2, x + n / 2, y + n / 2, arr);
	}
	
	public static boolean isBlock(int n, int x, int y, int[][] arr) {
        for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
                if (arr[x][y] != arr[i][j])
                    return false;
			}
		}
        answer[arr[x][y]]++;
		return true;
	}
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
        System.out.println(Arrays.toString(solution(arr)));
    }
	
}
