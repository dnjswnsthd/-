package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2564 {

	static int x, y, n;
	static int loc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine()) + 1;
		int dir, dist;
		int[] arr[] = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			arr[i] = new int[] { dir, dist };
		}
		loc = Location(arr[n - 1][0], arr[n - 1][1]); // ������ ��ġ
		int shop, dis, sum = 0;
		for (int i = 0; i < n - 1; i++) {
			shop = Location(arr[i][0], arr[i][1]);
			dis = Math.abs(loc - shop);
			sum += Math.min(dis, x + x + y + y - dis); // �� ª�� �Ÿ��� �����ش�.
		}
		System.out.println(sum);
	}
	private static int Location(int dir, int dist) { // �簢�� ���� ���������� �مf���� ��ġ
		switch (dir) {
		case 1:// ��
			return x + y - dist;
		case 2:// ��
			return x + y + y + dist;
		case 3:// ��
			return x + y + dist;
		case 4:// ��
			return y - dist;
		}
		return 0;
	}
}