package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �ִ񰪰� �ּڰ�
public class Pro_strMinMax {
    public static String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");
        int [] n = new int [tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            n[i] = Integer.parseInt(tmp[i]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n.length; i++) {
            max = Math.max(max, n[i]);
            min = Math.min(min, n[i]);
        }
        answer += min + " ";
        answer += max;
        return answer;
    }
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }
}
