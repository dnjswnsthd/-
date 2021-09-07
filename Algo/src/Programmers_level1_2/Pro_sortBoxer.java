package Programmers_level1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 코딩테스트 연습 6주차
public class Pro_sortBoxer {
    public static int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        List<Boxer> boxer = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            boxer.add(new Boxer(i + 1, weights[i]));
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (head2head[i].charAt(j) != 'N') {
                    boxer.get(i).game++;
                }
                if (head2head[i].charAt(j) == 'W') {
                    boxer.get(i).wins++;
                    if (boxer.get(j).weight > boxer.get(i).weight)
                        boxer.get(i).overWin++;
                }
            }
        }
        boxer.stream().forEach(tmp ->{
            if(tmp.game > 0){
                tmp.rate = (double) tmp.wins / tmp.game;
            }
        });
        boxer.sort((x, y) -> {
            if(x.rate != y.rate){
                return (y.rate - x.rate) > 0 ? 1 : -1;
            }else if(x.overWin != y.overWin){
                return y.overWin - x.overWin;
            } else if (x.weight != y.weight) {
                return y.weight - x.weight;
            } else {
                return x.id - y.id;
            }
        });

        return boxer.stream().mapToInt(x -> x.id).toArray();
    }

    public static class Boxer {
        int id;
        int weight;
        int wins;
        int game;
        int overWin;
        double rate;

        public Boxer(int id, int weight) {
            this.id = id;
            this.weight = weight;
            this.wins = 0;
            this.game = 0;
            this.rate = 0;
        }
    }

    public static void main(String[] args) {
        int[] weights = { 50, 82, 75, 120 };
        String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };
        System.out.println(Arrays.toString(solution(weights, head2head)));
    }
    
}
