package toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class toss5 {
    public static int[] solution(int[] fruitWeights, int k) {
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < fruitWeights.length - k + 1; i++) {
            int max = 0;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, fruitWeights[j]);
            }
            hs.add(max);
        }
        ArrayList<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int tmp = 0;
        for (int i = list.size() - 1; i >= 0; i--){
            answer[tmp] = list.get(i);
            tmp++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] fruitWeights = { 30, 40, 10, 20, 30 };
        int k = 3;
        System.out.println(Arrays.toString(solution(fruitWeights, k)));
    }
}
