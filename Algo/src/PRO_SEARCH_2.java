import java.util.HashSet;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ����Ž�� �Ҽ� ã��

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
	//����������� ������ �ڸ��� �����
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
