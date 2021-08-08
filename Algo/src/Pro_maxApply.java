import java.util.Arrays;

// 프로그래머스 코딩테스트 연습 예산

public class Pro_maxApply {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);   
        int sum = 0;
        for(int i = 0; i < d.length; i++){
            sum += d[i];
            if (sum > budget) {
                answer = i;
                break;
            }
        }
        if (sum <= budget)
            return d.length;
        return answer;
    }

    public static void main(String[] args) {
        int[] d = { 1,3,2,5,4 };
        int budget = 9;
        System.out.println(solution(d, budget));
    }
}
