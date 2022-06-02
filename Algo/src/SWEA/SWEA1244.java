package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 * 22.06.02
 */
public class SWEA1244 {
	private static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int swap = Integer.parseInt(st.nextToken());
			char [] nums = Integer.toString(num).toCharArray();
			dfs(swap, 0, nums);
			System.out.println("#" + t + " " + res);
		}
	}
	public static void dfs(int swap, int start, char [] nums) {
		if(swap == 0) {
			int tmp = Integer.parseInt(new String(nums));
			if (tmp > res) res = tmp;
			return;
		}
		for(int i = start; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				char c = nums[i];
				nums[i] = nums[j];
				nums[j] = c;
				dfs(swap - 1, i, nums);
				nums[j] = nums[i];
				nums[i] = c;
			}
		}
	}
}
