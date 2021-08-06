import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 나누어 떨어지는 숫자 배열

public class Pro_divNumArr {
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int[] not = { -1 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                pq.add(arr[i]);
            }
        }
        int size = pq.size();
        answer = new int[size];
        if (pq.isEmpty())
            return not;
        for (int i = 0; i < size; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 36, 1, 3 };
        int divisor = 1;
        System.out.println(Arrays.toString(solution(arr, divisor)));
    }
}
