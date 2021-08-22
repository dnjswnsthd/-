package Programmers_level1_2;

import java.util.Arrays;
// 프로그래머스 코딩테스트 연습 2개 이하로 다른 비트
public class Pro_twoBitDif {
    public static long[] solution(long[] numbers) {
        long[] answer = new long [numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String s = Long.toBinaryString(numbers[i]);
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int ba = s.lastIndexOf("0");
                int fr = s.indexOf("1", ba);
                if(ba == -1){
                    numbers[i]++;
                    s = Long.toBinaryString(numbers[i]);
                    s = s.substring(0, 2) + s.substring(2, s.length()).replace("0", "1");
                }else{
                    s = s.substring(0, ba)+"1" + s.substring(ba + 1, fr) + "0" + s.substring(fr + 1, s.length());
                }
                answer[i] = Long.parseLong(s, 2);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        long[] numbers = { 2, 7 };
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
