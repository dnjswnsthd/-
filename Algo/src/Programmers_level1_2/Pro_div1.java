package Programmers_level1_2;

/*
* 코딩테스트 연습 > 월간 코드 챌린지 시즌3 > 나머지가 1이 되는 수 찾기
* 2022.03.07
*/
public class Pro_div1 {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1)
                return i;
        }
        return n - 1;
    }
}
