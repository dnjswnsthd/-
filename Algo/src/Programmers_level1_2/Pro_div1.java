package Programmers_level1_2;

/*
* �ڵ��׽�Ʈ ���� > ���� �ڵ� ç���� ����3 > �������� 1�� �Ǵ� �� ã��
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
