import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 자연수 뒤집어 배열로 만들기
public class Pro_reverseArr {
    public static int[] solution(long n) {
        String s = Long.toString(n);
        int[] answer = new int [s.length()];
        int tmp = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            answer[tmp] = Character.getNumericValue(s.charAt(i));
            tmp++;
        }
        return answer;
    }
    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }
}
