package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2615 {
	//8방위 탐색을 할 필요없이 바둑판의 위쪽부터 탐색하기 떄문에 우, 우하단, 하단, 좌하단을 체크해주기 위한 dir
	private static int [][] dir = {{0,1},{-1,1},{1,0},{1,1}};
	//바둑판
	private static int[][] map = new int[19][19];
	//승리한 팀이 있는지 확인하기 위한 
	private static boolean chk; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//바둑판 입력
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//승리한 팀을 찾을 때까지 바둑판을 탐색한다.
		loop:for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				//바둑판이 비어있지 않을 경우
				if(map[i][j] != 0) {
					//user 1 : 흑돌  2: 백돌
					int user = map[i][j];
					//방위 탐색
					for (int k = 0; k < 4; k++) {
						//오목인지 확인하기 위한 변수
						int cnt = 1;
						int nx = i;
						int ny = j;
						while (true) {
							nx += dir[k][0];
							ny += dir[k][1];
							//범위 벗어나면 break
							if(!arrange_chk(nx, ny)) break;
							//같은 user이면 카운트 ++ 아니면 break
							if(map[nx][ny] == user) {
								cnt++;
							}else {
								break;
							}
						}
						//오목인 경우 
						if(cnt == 5) {
							nx = i - dir[k][0];
							ny = j - dir[k][1];
							//육목이 아닌 경우(오목 이후에 범위 밖으로 나가거나, 같은 유저의 돌이 아닐 때)
							if(!arrange_chk(nx, ny) || map[nx][ny] != user) {
								System.out.println(user);
								System.out.println((i+1) + " " + (j+1));
								chk = true;
								break loop;
							}
						}
					}
				}
			}
		}
		if(!chk) {
			System.out.println(0);
		}
	}
	
	static boolean arrange_chk(int row, int col) {
		return row >= 0 && row < 19 && col >= 0 && col < 19;
	}
}
