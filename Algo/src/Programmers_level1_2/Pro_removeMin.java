package Programmers_level1_2;

import java.util.Arrays;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���� ���� �� �����ϱ�

public class Pro_removeMin {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        int[] ex = { -1 };
        if (arr.length <= 1)
            return ex;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) 
                tmp++;
        }
        answer = new int[arr.length - tmp];
        tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                answer[tmp] = arr[i];
                tmp++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(solution(arr)));
    }
}
