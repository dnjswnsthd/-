// 프로그래머스 코딩테스트 연습 dfs/bfs 네트워크
public class Pro_dfsbfs_2 {
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
        	if(!chk[i]) {
        		dfs(computers, i, chk);
        		answer++;
        	}
        }
        return answer;
    }
	public static boolean [] dfs(int [][] computer, int idx, boolean [] chk) {
		chk[idx] = true;
		for(int i = 0; i < computer.length; i++) {
			if(idx != i && computer[idx][i] == 1 && chk[i] == false) {
				chk = dfs(computer, i, chk);
			}
		}
		return chk;
	}
	public static void main(String [] args) {
		int a = 3;
		int [][] b = {{1,1,0}, {1,1,0},{0,0,1}};
		System.out.println(solution(a,b));
		
	}
}
