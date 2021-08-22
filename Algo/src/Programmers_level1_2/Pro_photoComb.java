package Programmers_level1_2;

import java.util.HashMap;

// 프로그래머스 코딩테스트 연습 2017 카카오코드 본선 단체사진 찍기

public class Pro_photoComb {
	static String [] condition;
	static HashMap <Character, Integer> map;
	static boolean [] visited;
	static int [] chk;
	static int answer;
	public static int solution(int n, String[] data) {
		condition = data;
		map = new HashMap<>();
		visited = new boolean[8];
		chk = new int [8]; 
		answer = 0;
		map.put('A',0); map.put('C',1);
		map.put('F',2); map.put('J',3);
		map.put('M',4); map.put('N',5);
		map.put('R',6); map.put('T',7);
		permutation(0);
        return answer;
    }
	private static void permutation(int i) {
		if(i == 8) {
			if(chk()) answer++;
		}else {
			for(int j = 0; j < 8; j++) {
				if(!visited[j]){
					visited[j] = true;
					chk[i] = j;
					permutation(i + 1);
					visited[j] = false;
				}
			}
		}
	}
	private static boolean chk() {
		for(String cond : condition) {
			int member1 = chk[map.get(cond.charAt(0))];
			int member2 = chk[map.get(cond.charAt(2))];
			char operation = cond.charAt(3);
			int size = cond.charAt(4) - '0' + 1;
			if(operation == '=') {
				if(Math.abs(member1 - member2) != size) return false;
			}else if(operation == '>') {
				if(Math.abs(member1 - member2) <= size) return false; 
			}else {
				if(Math.abs(member1 - member2) >= size) return false;
			}
		}
		return true;
	}
	public static void main(String [] args) {
		int n = 2;
		String [] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(n, data));
	}
}
