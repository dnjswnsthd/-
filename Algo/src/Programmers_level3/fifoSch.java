package Programmers_level3;

/*
 * 선입 선출 스케줄링 java
 * 22.06.19
 */
public class fifoSch {
	public int solution(int n, int[] cores) {
		int[] time = new int[100001];
		for (int i = 0; i < cores.length; i++) {
			int t = 1;
			while (t <= 100000) {
				time[t]++;
				t += cores[i];
			}
		}

		int work = 0;
		int target_time = 0;
		int count = 0;
		for (int t = 0; t < 100000; t++) {
			work += time[t];
			if (work < n && n <= work + time[t + 1]) {
				count = n - work;
				target_time = t + 1;
				break;
			}
		}

		int answer = 0;
		for (int i = 0; i < cores.length; i++) {
			if ((target_time - 1) % cores[i] == 0) {
				count--;
				if (count == 0) {
					answer = i + 1;
					break;
				}
			}
		}
		return answer;
	}
}
