import java.util.Arrays;
// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���� ������������ ��ġ�ϱ�
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
