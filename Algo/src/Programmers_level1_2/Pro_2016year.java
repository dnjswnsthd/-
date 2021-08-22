package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 2016년 
public class Pro_2016year {
    public static String solution(int a, int b) {
        String [] dayOf = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += day[i];
        }
        sum += b;
        if (sum % 7 != 0)
            return dayOf[(sum % 7) - 1];
        else
            return dayOf[6];
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 7;
        System.out.println(solution(a, b));
    }
}
