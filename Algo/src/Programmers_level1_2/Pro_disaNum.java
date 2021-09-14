package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 없는 숫자 더하기

public class Pro_disaNum {
    public static int solution(int[] numbers) {
        int answer = 0;
        int[] nums = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            nums[numbers[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
        System.out.println(solution(numbers));
    }
}
