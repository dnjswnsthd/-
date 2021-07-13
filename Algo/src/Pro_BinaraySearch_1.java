import java.util.Arrays;

public class Pro_BinaraySearch_1 {
	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		long min = 1;
		long max = (long)times[times.length-1]*n;
		long mid = 0;
		long sum = 0;
		long answer = max;
		while(min <= max) {
			sum = 0;
			mid = (min + max) / 2;
			System.out.println(mid);
			for(int t : times) {
				sum += mid / t; // 1 명당 맡을 수 있는 입국자 수
			}
			if(sum >= n) {
				if(mid < answer) {
					answer = mid;
				}
				max = mid - 1;
			}
			else {
				min = mid + 1;
			}
		}
        return answer;
    }
	public static void 	main(String [] args) {
		int a = 6;
		int [] b = {7, 10};
		System.out.println(solution(a,b));
	}
}
