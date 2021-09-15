package Programmers_level3;

import java.util.ArrayList;

// 프로그래머스 코딩테스트 연습 하노이탑

public class Pro_hanoi {
    static ArrayList<int[]> seq;
    public static int[][] solution(int n) {
        seq = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];  
        }
        
        return answer;
    }
    
    private static void hanoi(int n, int from, int to, int via) {
        int[] move = { from, to };

        if (n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
