import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//	BFS를 통해 치즈내부의 공기를 제외한 외부의 공기들을 구분. 
//	치즈와 맞닿은 외부 공기를 기준으로, 치즈를 que에 추가
//	입력된 치즈를 외부 공기로 치환하며, 치환된 공기를 que에 입력.
//	위의 2,3번 과정을 반복하며, que에 값이 없을 경우 반복문 종료.
//	외부공기를 나타내는 cnt로 횟수를 나태냈지만, 초기화를 2로 했기에
public class BOJ2636 {
	static int N, M, last, cnt; 	// 행, 렬, 마지막 치즈 조각, 시간
	static boolean chk = true; 	// while 문을 위한 boolean
	static int[][] map; 			// 입력받을 2차원 배열
	static boolean[][] visit; 		// 방문 관리 2차원 배열
	static Queue<pair> airQue = new LinkedList<pair>(); // 주변을 외부 공기로 변환 할 좌표
	static Queue<pair> meltQue = new LinkedList<pair>(); 		// 주변 치즈를 녹일 공기 좌표
	// 4바위 탐색
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];		// 입력 받을 2차원 배열
		visit = new boolean[N][M];	// 방문 관리 2차원 배열
		cnt = 2; 	// 외부 공기 및 시간 관리
		last = 0; 	// 마지막 치즈 조각 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; // 치즈인 경우
				}
			}
		}
		while (chk) {
			map_bfs(); 	// 공기 구분
			targetCheese(); // 치즈 녹이기
		}
		br.close();
		System.out.println(cnt -2);
		System.out.println(last);
	}
	// 범위 검사
	public static boolean range_chk(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}
	// 내부 공기 -> 외부 공기 구분 및 변환
	public static void map_bfs() {
		// 첫 호출만 동작
		if (airQue.isEmpty())
			airQue.offer(new pair(0, 0));
		while (!airQue.isEmpty()) {
			int row = airQue.peek().row;
			int col = airQue.poll().col;
			map[row][col] = cnt; 	// 외부공기 구분
			visit[row][col] = true;
			for (int k = 0; k < 4; k++) {
				int nr = row + dy[k];
				int nc = col + dx[k];
				// 범위 검사
				if (!range_chk(nr, nc))
					continue;
				// 방문 검사
				if (visit[nr][nc])
					continue;
				// 내부 공기 외부공기로 치환
				if (map[nr][nc] == 0) {
					visit[nr][nc] = true; // 방문 처리
					airQue.offer(new pair(nr, nc));
					continue;
				}
				// 주변에 치즈가 있는 경우
				if (map[nr][nc] == -1) {
					visit[nr][nc] = true;
					meltQue.offer(new pair(row, col)); // 주변 치즈를 녹일 공기 좌표를 큐에 삽입.
				}
			}
		}
	}
	// 치즈 녹이기 && 치즈 -> 공기로 바뀐 좌표 처리
	public static void targetCheese() {
		while (!meltQue.isEmpty()) {
			int row = meltQue.peek().row;
			int col = meltQue.poll().col;
			for (int k = 0; k < 4; k++) {
				int nr = row + dy[k];
				int nc = col + dx[k];
				// 범위 검사 && 주변이 치즈인 경우
				if (range_chk(nr, nc) && map[nr][nc] == -1) {
					map[nr][nc] = cnt + 1; 			// 해당 자리는 공기로 치환 (변환된 치즈의 개수)
					airQue.offer(new pair(nr, nc)); 	// 큐에 입력(이웃한값들을 탐색하기 위해)
				}
			}
		}
		// 더이상 치즈가 없는 경우
		if (airQue.isEmpty()) {
			chk = false;
			return;
		}
		++cnt; // 횟수 추가
		last = airQue.size(); // 치즈 개수
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