package Programmers_kit;

import java.util.HashSet;
// 프로그래머스 코딩테스트 연습 그래프 방의개수
class Solution {
	public static int solution(int[] arrows) {
		int answer = 0;
		int[][] move = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }};
		HashSet<Point> point = new HashSet<>();
		HashSet<Edge> edge = new HashSet<>();
		int r = 0, c = 0;
		point.add(new Point(r, c));
		for (int i = 0, size = arrows.length; i < size; i++) {
			int d = arrows[i];
			r += move[d][0];
			c += move[d][1];
			Point cur = new Point(r, c);
			if (edge.contains(new Edge(r - move[d][0], c - move[d][1], r, c, d))) continue;
			if (point.contains(cur)) {
				answer++;
			} else {
				point.add(cur);
			}
			if (d % 2 == 1 && edge.contains(new Edge(r - move[d][0], c, r, c - move[d][1], ((d + 2) % 8)))) answer++;
			edge.add(new Edge(r - move[d][0], c - move[d][1], r, c, d));// edge 추가
		}
		return answer;
	}
	public static void main(String [] args) {
		int [] a = {6,6,6,4,4,4,2,2,2,0,0,0,1,6,5,5,3,6,0};
		System.out.println(solution(a));
	}
	static class Edge {
		int r1, r2, c1, c2, d;
		Edge(int r1, int c1, int r2, int c2, int d) {
			this.r1 = r1;
			this.r2 = r2;
			this.c1 = c1;
			this.c2 = c2;
			this.d = d;
		}
		@Override
		public boolean equals(Object obj) {
			Edge e = (Edge) obj;
			if ((e.r1 + e.r2 == this.r1 + this.r2) && (e.c1 + e.c2 == this.c1 + this.c2)&& (Math.abs(e.d - this.d) == 4 || e.d == this.d))return true;
			return false;
		}
		@Override
		public int hashCode() {
			int prime = 31;
			int hashcode = 1;
			int dir = this.d;
			if (this.d < 4) dir += 4;
			hashcode = prime * hashcode + (this.r1 + this.r2);
			hashcode = prime * hashcode + (this.c1 + this.c2);
			hashcode = prime * hashcode + dir;
			return hashcode;
		}
	}
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			if (this.r == p.r && this.c == p.c) return true;
			return false;
		}
		@Override
		public int hashCode() {
			int prime = 31;
			int hashcode = 1;
			hashcode = prime * hashcode + this.r;
			hashcode = prime * hashcode + this.c;
			return hashcode;
		}
	}
}