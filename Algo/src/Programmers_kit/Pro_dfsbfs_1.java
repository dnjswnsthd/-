package Programmers_kit;

// 프로그래머스 코딩테스트 연습 dfs/bfs 타겟 넘버
public class Pro_dfsbfs_1 {
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int init = numbers[0];
        answer += dfs(init, 1, numbers, target);
        answer += dfs(-init, 1, numbers, target);
        return answer;
    }
	public static int dfs(int prev, int idx, int [] num, int target) {
		if(idx == num.length) {
			if(target == prev) return 1;
			return 0;
		}
		int current1 = prev + num[idx];
		int current2 = prev - num[idx];
		int res = 0;
		res += dfs(current1, idx + 1, num, target);
		res += dfs(current2, idx + 1, num, target);
		return res;
	}
	public static void main(String [] args) {
		int [] a = {1, 1, 1, 1, 1};
		int b = 3;
		System.out.println(solution(a, b));
	}
}