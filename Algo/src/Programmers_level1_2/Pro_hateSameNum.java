package Programmers_level1_2;

import java.util.Arrays;
import java.util.Stack;

// 프로그래머스 코딩테스트 연습 같은 숫자는 싫어

public class Pro_hateSameNum {
    public static int[] solution(int[] arr) {
        Stack<Integer> answer = new Stack<>();
        answer.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (answer.peek() != arr[i])
                answer.push(arr[i]);
        }
        int[] ans = new int[answer.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = answer.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
        System.out.println(Arrays.toString(solution(arr)));
    }
}
