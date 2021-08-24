package talentX;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class talentX2 {
    public static List<String> groupTransactions(List<String> transactions) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            pq.add(transactions.get(i));
        }
        while (!pq.isEmpty()) {
            String tmp = pq.poll();
            int cnt = 1;
            while (tmp == pq.peek()) {
                cnt++;
                pq.poll();
            }
            answer.add(tmp + " " + cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<String> transactions = new ArrayList<>();
        transactions.add("bin");
        transactions.add("can");
        transactions.add("bin");
        transactions.add("bin");
        System.out.println(groupTransactions(transactions));
    }
}
