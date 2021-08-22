package Programmers_level1_2;

import java.util.Stack;
// 프로그래머스 크레인 인형뽑기 게임

class Pro_craneDoll {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int tmp = 0;
            while (tmp < board.length && board[tmp][moves[i] - 1] == 0) {
                tmp++;
            }
            if (tmp < board.length) {
                if(!st.isEmpty() && board[tmp][moves[i] - 1] == st.peek()){
                    board[tmp][moves[i] - 1] = 0;
                    st.pop();
                    answer += 2;
                } else {
                    st.push(board[tmp][moves[i] - 1]);
                    board[tmp][moves[i] - 1] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        System.out.println(solution(board, moves));
    }
}