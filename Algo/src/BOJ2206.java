import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
	private static int n, m;
	//map
	private static int [][] map;
	//�ִ� �Ÿ� ������ �迭
	private static int [][] res;
	//�� �μ� Ƚ�� ���� �迭
	private static int [][] cnt;
	//4���� Ž��
	private static int [] dx = {-1, 0, 1, 0};
	private static int [] dy = {0, 1, 0, -1};
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		res = new int[n+1][m+1];
		cnt = new int[n+1][m+1];
		//�� �μ� Ƚ���� 2�� �ʱ�ȭ.(�湮���� ���� ���)
		for(int [] r : cnt) Arrays.fill(r, 2);
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		int res = sol();
		System.out.println(res);
	}
	public static int sol() {
		Queue <Pair> que = new LinkedList <> ();
		que.add(new Pair(1, 1, 0));
		res[1][1] = 1;
		cnt[1][1] = 0;
		
		while(!que.isEmpty()) {
			Pair cur = que.poll();
			if(cur.r == n && cur.c == m) return res[n][m];
			for(int i = 0; i < 4; i++) {
				int nx = cur.r + dx[i];
				int ny = cur.c + dy[i];
				//�� �̸�
				if(arrange_chk(nx, ny) && wall_chk(nx, ny)) {
					//�μ� ���� 0�϶���
					if(cur.cnt == 0) {
						que.add(new Pair(nx, ny, 1));
						res[nx][ny] = res[cur.r][cur.c]+ 1;
						//�μ� ���� 1
						cnt[nx][ny] = 1;
					}
				//���� �ƴ� ���
				}else if(arrange_chk(nx, ny) && !wall_chk(nx, ny)) {
					// �̵��� ���� ���� �ν� Ƚ���� 1�̸� ���� �μ� Ƚ���� 0�� ��츸 ť �߰�
					// �̵��� ���� ���� �ν� Ƚ���� 2�̸� �̹湮�̱� ������ �μ� Ƚ�� 0, 1 �Ѵ� ť�� �߰�
					if(cnt[nx][ny] > cur.cnt) {
						que.add(new Pair(nx, ny, cur.cnt));
						res[nx][ny] = res[cur.r][cur.c] + 1;
						cnt[nx][ny] = cur.cnt;
					}
				}
			}
		}
		return -1;
	}
	// ���� üũ (���� ������ true)
	public static boolean arrange_chk(int r, int c) {
		if(r < 1 || r > n || c < 1 || c > m) return false;
		else return true;
	}
	// �� üũ (�� �̸� true)
	public static boolean wall_chk(int r, int c) {
		if(map[r][c] == 1) return true;
		else return false;
	}
	public static class Pair{
		int r, c;
		int cnt;
		public Pair(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}