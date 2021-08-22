package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2615 {
	//8���� Ž���� �� �ʿ���� �ٵ����� ���ʺ��� Ž���ϱ� ������ ��, ���ϴ�, �ϴ�, ���ϴ��� üũ���ֱ� ���� dir
	private static int [][] dir = {{0,1},{-1,1},{1,0},{1,1}};
	//�ٵ���
	private static int[][] map = new int[19][19];
	//�¸��� ���� �ִ��� Ȯ���ϱ� ���� 
	private static boolean chk; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//�ٵ��� �Է�
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//�¸��� ���� ã�� ������ �ٵ����� Ž���Ѵ�.
		loop:for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				//�ٵ����� ������� ���� ���
				if(map[i][j] != 0) {
					//user 1 : �浹  2: �鵹
					int user = map[i][j];
					//���� Ž��
					for (int k = 0; k < 4; k++) {
						//�������� Ȯ���ϱ� ���� ����
						int cnt = 1;
						int nx = i;
						int ny = j;
						while (true) {
							nx += dir[k][0];
							ny += dir[k][1];
							//���� ����� break
							if(!arrange_chk(nx, ny)) break;
							//���� user�̸� ī��Ʈ ++ �ƴϸ� break
							if(map[nx][ny] == user) {
								cnt++;
							}else {
								break;
							}
						}
						//������ ��� 
						if(cnt == 5) {
							nx = i - dir[k][0];
							ny = j - dir[k][1];
							//������ �ƴ� ���(���� ���Ŀ� ���� ������ �����ų�, ���� ������ ���� �ƴ� ��)
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
