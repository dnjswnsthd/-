import java.util.HashSet;

// 프로그래머스 코딩테스트 연습 완전탐색 소수 찾기

public class PRO_SEARCH_2 {
	public static int solution(String numbers) {
        HashSet <Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int cnt = 0;
        while(set.iterator().hasNext()) {
        	int n = set.iterator().next();
        	set.remove(n);
        	if(n == 2) cnt++;
        	if(n % 2 != 0 && isPrime(n)) {
        		cnt++;
        	}
        }
        return cnt;
    }
	//순열방식으로 각각의 자리를 만들기
    public static void permutation(String prefix, String str, HashSet<Integer> set) { 
        int n = str.length();        
        if(!prefix.equals("")) {
           set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
    public static boolean isPrime(int n) {
    	if(n == 0 || n== 1) return false;
    	for(int i = 2; i <= (int)Math.sqrt(n); i++) {
    		if(n % i == 0) return false;
    	}
    	return true;
    }
	public static void main(String [] args) {
		String a = "17";
		System.out.println(solution(a));
	}
}
