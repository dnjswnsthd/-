import java.util.ArrayList;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� Greedy ū �� �����

public class Pro_Greedy_3 {
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int idx = 0, max = 0; 
		for (int i = 0; i < number.length() - k; i++) {
			max = 0;
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "1231234";
		int b = 3;
		System.out.println(solution(a, b));
	}
}
