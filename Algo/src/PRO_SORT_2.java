import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 코딩테스트 연습 정렬 가장 큰 수(Comparator String 비교)

public class PRO_SORT_2 {
	public static String solution(int[] numbers) {
        String answer = "";
        String [] str = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		return ((o2 + o1).compareTo(o1 + o2));
        	}
        });
        if(str[0].equals("0")) return "0";
        for(int i = 0; i < str.length; i++) {
        	answer += str[i];
        }
        return answer;
    }
	public static void main(String [] args) {
		int [] a = {6, 10, 2};
		System.out.println(solution(a));
	}
}
