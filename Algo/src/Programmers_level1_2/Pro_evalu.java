package Programmers_level1_2;

// 프로그래머스 위클리 챌린지 2주차 상호 평가
public class Pro_evalu {
    public static String solution(int[][] scores) {
        String answer = "";
        for (int j = 0; j < scores.length; j++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int size = scores.length;
            for (int i = 0; i < scores.length; i++) {
                sum += scores[i][j];
                if (max < scores[i][j])
                    max = scores[i][j];
                if (min > scores[i][j])
                    min = scores[i][j];
            }
            int cntMax = 0;
            int cntMin = 0;
            for (int i = 0; i < scores.length; i++) {
                if (max == scores[i][j])
                    cntMax++;
                if (min == scores[i][j])
                    cntMin++;
            }
            if (cntMax == 1 && scores[j][j] == max) {
                sum -= max;
                size -= 1;
            } else if (cntMin == 1 && scores[j][j] == min) {
                sum -= min;
                size -= 1;
            }
            double avg = sum / size;
            if (avg >= 90)
                answer += "A";
            else if (avg >= 80)
                answer += "B";
            else if (avg >= 70)
                answer += "C";
            else if (avg >= 50) 
                answer += "D";
            else
                answer += "F";
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
                { 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
        System.out.println(solution(scores));
    }
}
