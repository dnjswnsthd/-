import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스 2개 골라서 더하기
public class Pro_selectTwoAdd {
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (i != j && !pq.contains(numbers[i] + numbers[j])) {
                    pq.add(numbers[i] + numbers[j]);
                }
            }
        }
        int size = pq.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 1, 3, 4, 1 };
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
