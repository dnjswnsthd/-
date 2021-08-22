package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 하샤드 수
public class Pro_hashardNum {
    public static boolean solution(int x) {
        String s = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += Character.getNumericValue(c);
        }
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int x = 11;
        System.out.println(solution(x));
    }
}
