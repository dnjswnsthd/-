package Programmers_level1_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 프로그래머스 코딩테스트 연습 배달

public class Pro_delivery {
    public static int solution(int N, int[][] road, int K) {
        final int MAX = 1000000;
        int answer = 0;
        int[][] adj = new int[N][N];
        for (var a : adj) {
            Arrays.fill(a, MAX);
        }

        for (var a : road) {
            int x = a[0] - 1;
            int y = a[1] - 1;
            int w = a[2];
            if (w < adj[x][y]) {
                adj[x][y] = adj[y][x] = w;
            }
        }
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, MAX);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(dist[o1], dist[o2]);
            }
        });
        dist[0] = 0;
        pq.add(0);

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (visited[curr])
                continue;

            visited[curr] = true;
            for (int i = 0; i < N; i++) {
                if (adj[curr][i] == MAX)
                    continue;

                if (dist[i] > dist[curr] + adj[curr][i]) {
                    dist[i] = dist[curr] + adj[curr][i];
                    pq.offer(i);
                }
            }
        }
        for (var a : dist) {
            if (a <= K)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
        int K = 3;
        System.out.println(solution(N, road, K));
    }
}
