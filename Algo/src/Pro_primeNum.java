// 프로그래머스 소수만들기
public class Pro_primeNum {
    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum))
                        answer++;
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int sum) {
        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(solution(nums));
    }
}
