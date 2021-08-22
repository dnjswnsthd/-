package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 가장 큰 정사각형 찾기

public class Pro_mostBigSq {
    public static int solution(int [][]board){
        int answer = 0;
        int width = board.length;
        int height = board[0].length;
        int[][] DP = new int[2][board[0].length];
        for (int i = 0; i < height; i++) {
            DP[0][i] = board[0][i];
            if (DP[0][i] > answer)
                answer = DP[0][i];
        }
        for (int i = 1; i < width; i++) {
            for (int j = 0; j < height; j++) {
                
                if (board[i][j] == 0)
                    DP[1][j] = 0;
                else {
                    if (j == 0)
                        DP[1][j] = 1;
                    else {
                        DP[1][j] = 1;
                        if (DP[1][j - 1] == 0 | DP[0][j] == 0 | DP[0][j - 1] == 0)
                            DP[1][j] = 1;
                        else if (DP[1][j - 1] == DP[0][j] && DP[0][j] == DP[0][j - 1])
                            DP[1][j] = DP[0][j] + 1;
                        else {
                            if (DP[1][j - 1] <= DP[0][j - 1] && DP[1][j - 1] <= DP[0][j])
                                DP[1][j] = DP[1][j - 1] + 1;
                            else if (DP[0][j - 1] <= DP[1][j - 1] && DP[0][j - 1] <= DP[0][j])
                                DP[1][j] = DP[0][j - 1] + 1;
                            else if (DP[0][j] <= DP[0][j - 1] && DP[0][j] <= DP[1][j - 1])
                                DP[1][j] = DP[0][j] + 1;
                        }
                    }
                }
                
                if (DP[1][j] > answer)
                    answer = DP[1][j];                    
            }
            for (int j = 0; j < height; j++) {
                DP[0][j] = DP[1][j];
            }
            
        }
        
        return answer*answer;
    }
    public static void main(String[] args) {
        int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
        System.out.println(solution(board));
    }
}
