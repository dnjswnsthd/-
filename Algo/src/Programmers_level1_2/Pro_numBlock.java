package Programmers_level1_2;
/*
 * 프로그래머스 숫자 블록
 * 22.06.06
 */
public class Pro_numBlock {
	int max = 10000000;

	public int findMinority(int num) { // 소수찾기 함수
		if (num == 1) {
			return 0;
		} // 1은 소수가 x

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0 && (num / i) <= max) {
				return num / i;
			}
		}
		return 1; // 1과 자기자신을 제외하고 소수가 없을 경우 1
	}

	public int[] solution(long begin, long end) {
        int[] answer = new int[(int)begin-(int) end+1];
        
        for(int i=(int)begin; i<=end; i++){
            answer[i-(int)begin] = findMinority(i); 
        }
        return answer;
    }
}
