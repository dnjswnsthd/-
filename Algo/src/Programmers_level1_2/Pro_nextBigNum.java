package Programmers_level1_2;

// 프로그래머스 코딩테스트 연습 다음 큰 숫자

public class Pro_nextBigNum {
    public static int solution(int n) {
        String biN = Integer.toBinaryString(n);
        int cnt = 0, tmp = 0;
        for (int i = 0; i < biN.length(); i++) {
            if (biN.charAt(i) == '1')
                cnt++;
        }
        while (tmp != cnt) {
            tmp = 0;
            n += 1;
            String biTmp = Integer.toBinaryString(n);
            for (int i = 0; i < biTmp.length(); i++) {
                if (biTmp.charAt(i) == '1')
                    tmp++;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}