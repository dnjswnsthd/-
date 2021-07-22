import java.util.HashSet;

// 프로그래머스 폰켓몬
public class Pro_폰켓몬 {
	public static int solution(int[] nums) {
	    int max = nums.length / 2;
	    HashSet<Integer> set = new HashSet<>();
	    for (int n : nums) {
	      set.add(n);
	    }
	    if (set.size() > max) {
	      return max;
	    } else {
	      return set.size();
	    }
	  }
	public static void main(String [] args) {
		int [] a = {3,1,2,3};
		System.out.println(solution(a));
	}
}
