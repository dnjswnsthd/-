import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//	BFS�� ���� ġ����� ���⸦ ������ �ܺ��� ������� ����. 
//	ġ��� �´��� �ܺ� ���⸦ ��������, ġ� que�� �߰�
//	�Էµ� ġ� �ܺ� ����� ġȯ�ϸ�, ġȯ�� ���⸦ que�� �Է�.
//	���� 2,3�� ������ �ݺ��ϸ�, que�� ���� ���� ��� �ݺ��� ����.
//	�ܺΰ��⸦ ��Ÿ���� cnt�� Ƚ���� ���³�����, �ʱ�ȭ�� 2�� �߱⿡
public class BOJ2636 {
	static int N, M, last, cnt; 	// ��, ��, ������ ġ�� ����, �ð�
	static boolean chk = true; 	// while ���� ���� boolean
	static int[][] map; 			// �Է¹��� 2���� �迭
	static boolean[][] visit; 		// �湮 ���� 2���� �迭
	static Queue<pair> airQue = new LinkedList<pair>(); // �ֺ��� �ܺ� ����� ��ȯ �� ��ǥ
	static Queue<pair> meltQue = new LinkedList<pair>(); 		// �ֺ� ġ� ���� ���� ��ǥ
	// 4���� Ž��
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];		// �Է� ���� 2���� �迭
		visit = new boolean[N][M];	// �湮 ���� 2���� �迭
		cnt = 2; 	// �ܺ� ���� �� �ð� ����
		last = 0; 	// ������ ġ�� ���� ����

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; // ġ���� ���
				}
			}
		}
		while (chk) {
			map_bfs(); 	// ���� ����
			targetCheese(); // ġ�� ���̱�
		}
		br.close();
		System.out.println(cnt -2);
		System.out.println(last);
	}
	// ���� �˻�
	public static boolean range_chk(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}
	// ���� ���� -> �ܺ� ���� ���� �� ��ȯ
	public static void map_bfs() {
		// ù ȣ�⸸ ����
		if (airQue.isEmpty())
			airQue.offer(new pair(0, 0));
		while (!airQue.isEmpty()) {
			int row = airQue.peek().row;
			int col = airQue.poll().col;
			map[row][col] = cnt; 	// �ܺΰ��� ����
			visit[row][col] = true;
			for (int k = 0; k < 4; k++) {
				int nr = row + dy[k];
				int nc = col + dx[k];
				// ���� �˻�
				if (!range_chk(nr, nc))
					continue;
				// �湮 �˻�
				if (visit[nr][nc])
					continue;
				// ���� ���� �ܺΰ���� ġȯ
				if (map[nr][nc] == 0) {
					visit[nr][nc] = true; // �湮 ó��
					airQue.offer(new pair(nr, nc));
					continue;
				}
				// �ֺ��� ġ� �ִ� ���
				if (map[nr][nc] == -1) {
					visit[nr][nc] = true;
					meltQue.offer(new pair(row, col)); // �ֺ� ġ� ���� ���� ��ǥ�� ť�� ����.
				}
			}
		}
	}
	// ġ�� ���̱� && ġ�� -> ����� �ٲ� ��ǥ ó��
	public static void targetCheese() {
		while (!meltQue.isEmpty()) {
			int row = meltQue.peek().row;
			int col = meltQue.poll().col;
			for (int k = 0; k < 4; k++) {
				int nr = row + dy[k];
				int nc = col + dx[k];
				// ���� �˻� && �ֺ��� ġ���� ���
				if (range_chk(nr, nc) && map[nr][nc] == -1) {
					map[nr][nc] = cnt + 1; 			// �ش� �ڸ��� ����� ġȯ (��ȯ�� ġ���� ����)
					airQue.offer(new pair(nr, nc)); 	// ť�� �Է�(�̿��Ѱ����� Ž���ϱ� ����)
				}
			}
		}
		// ���̻� ġ� ���� ���
		if (airQue.isEmpty()) {
			chk = false;
			return;
		}
		++cnt; // Ƚ�� �߰�
		last = airQue.size(); // ġ�� ����
	}
}
class pair {
	int row;
	int col;

	public pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}