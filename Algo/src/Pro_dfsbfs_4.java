import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 코딩테스트 연습 dfs/bfs 여행경로
public class Pro_dfsbfs_4 {
	static boolean [] chk;
	static ArrayList <String> answers;
	public static String[] solution(String[][] tickets) {
		chk = new boolean[tickets.length];
		answers = new ArrayList<String>();
		int cnt = 0;
		dfs(cnt, "ICN", "ICN", tickets);
		Collections.sort(answers);
		String [] answer = answers.get(0).split("/");
        return answer;
    }
	public static void dfs(int cnt, String prev, String answer, String [][] tickets) {
		if(cnt == tickets.length) {
			answers.add(answer);
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if(!chk[i] && tickets[i][0].equals(prev)) {
				chk[i] = true;
				dfs(cnt + 1, tickets[i][1], answer+"/"+tickets[i][1], tickets);
				chk[i] = false;
			}
		}
		return ;
	}
	public static void main(String [] args) {
		String [][] a = {{"ICN", "SFO"}, {"ICN","ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(Arrays.toString(solution(a)));
	}
}
