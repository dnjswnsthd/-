package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/*
 * SWEA 3752. 가능한 시험 점수
 * 22.06.09
 */
public class SWEA3752 {
	static Set<Integer> set;
	static int[] scores;
	static ArrayList<Integer> al;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			scores = new int[n];
			set = new HashSet<>();
			al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			set.add(0);
			al.add(0);
			calcScore(0);
			System.out.println("#" + t + " " + set.size());
		}
	}

	public static void calcScore(int cnt) {
		if (cnt == scores.length) {
			return;
		}
		int len = al.size();
		for (int i = 0; i < len; i++) {
			if (!set.contains(al.get(i) + scores[cnt])) {
				set.add(al.get(i) + scores[cnt]);
				al.add(al.get(i) + scores[cnt]);
			}
		}
		calcScore(cnt + 1);
	}
}
