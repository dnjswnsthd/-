package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewelry[] jew = new Jewelry[N];
		int[] bag = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jew[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jew);
		Arrays.sort(bag);
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		long priceSum = 0L;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && jew[idx].weight <= bag[i]) {
				pq.add(jew[idx].price);
				idx++;
			}
			if (!pq.isEmpty()) priceSum += pq.poll();
		}
		System.out.println(priceSum);
	}

	static class Jewelry implements Comparable<Jewelry> {
		int weight;
		int price;

		private Jewelry(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewelry o) {
			return this.weight - o.weight;
		}
	}
}