package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * SWEA 1983 조교의 성적 매기기
 * 22.05.26
 */
public class SWEA1983 {
	private static String [] grade = {"A+","A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"}; 
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int student = Integer.parseInt(st.nextToken());
			ArrayList <Double> scores = new ArrayList <>();
			double memoryScore = 0;
			for(int i = 0; i < students; i++) {
				st = new StringTokenizer(br.readLine());
				double score = (Integer.parseInt(st.nextToken()) * 0.35) + (Integer.parseInt(st.nextToken()) * 0.45) + (Integer.parseInt(st.nextToken()) * 0.20);
				scores.add(score);
				if(i == student - 1) {
					memoryScore = score;
				}
			}
			Collections.sort(scores, Collections.reverseOrder());
			int tmp = scores.indexOf(memoryScore);
			System.out.println("#" + t + " " + grade[tmp/(students/10)]);
		}
	}
}
