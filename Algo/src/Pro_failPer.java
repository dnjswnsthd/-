import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 프로그래머스 실패율

public class Pro_failPer {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < stages.length; i++) {
            pq.add(stages[i]);
        }
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            int size = pq.size();
            while (!pq.isEmpty() && pq.peek() == i) {
                cnt += 1;
                pq.poll();
            }
            if (cnt == 0) {
                map.put(i, (double)0);    
            }else{
                map.put(i, (double) cnt / (double) size);
            }
        }
        for (int i = 0; i < N; i++) {
            double max = Integer.MIN_VALUE;
            int key = 0;
            for (Integer k : map.keySet()) {
                if (max < map.get(k)) {
                    max = map.get(k);
                    key = k;
                }
            }
            answer[i] = key;
            map.remove(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] stages = { 4,4,4,4,4 };
        System.out.println(Arrays.toString(solution(N, stages)));
    }
}
