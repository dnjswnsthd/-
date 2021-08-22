package Programmers_kit;

// 프로그래머스 코딩테스트 연습 dfs/bfs 단어 변환
public class Pro_dfsbfs_3 {
	static boolean[] chk;
	static int answer = 0;
	public static int solution(String begin, String target, String[] words) {
		chk = new boolean[words.length];
		dfs(begin, target, 0, words);
        return answer;
    }
	public static void dfs(String tmp, String target, int cnt, String[] words) {
		if(tmp.equals(target)) {
			answer = cnt;
			return;
		}
		for(int i = 0; i < words.length; i++) {
			if(chk[i]) continue;
			
			if(compareStr(tmp, words[i]) == 1) {
				chk[i] = true;
				dfs(words[i], target, cnt + 1, words);
				chk[i] = false;
			}
		}
	}
	public static int compareStr(String words1, String words2) {
		int cnt = 0;
		for(int i = 0; i < words1.length(); i++) {
			if(words1.charAt(i) != words2.charAt(i)) {
				cnt++;
			}
		}
		
		return cnt;
	}
	public static void main(String [] args) {
		String a = "hit";
		String b = "cog";
		String [] c = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(a,b,c));
	}
}
