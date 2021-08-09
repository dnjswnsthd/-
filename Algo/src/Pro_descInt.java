import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 정수 내림차순으로 배치하기
public class Pro_descInt {
    public static long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        char[] c = s.toCharArray();
        int[] num = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            num[i] = Character.getNumericValue(c[i]);
        }
        Arrays.sort(num);
        String ss = "";
        for (int i = num.length - 1; i >= 0; i--) {
            ss += num[i];
        }
        answer = Long.parseLong(ss);
        return answer;
    }
    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));
    }
}
