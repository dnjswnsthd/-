package Programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ����/ť �ֽİ���
// ���� �տ������� �ڿ��Ͱ� ���ϸ� ������ ������ �ҿ�ð��� ����
// break���� �ҿ�ð��� �߰������ ������ ������ ���ð��� �� (���ǻ���)

public class PRO_STQU_4 {
	public static int[] solution(int[] prices) {
        ArrayList <Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < prices.length - 1; i++) {
        	int j = i + 1;
        	int cnt = 0;
        	while(j < prices.length) {
        		if(prices[i] > prices[j]) { cnt++; break;}
        		cnt++;
        		j++;
        	}
        	if(cnt == 0) {
        		answer.add(1);
        	}else {
        		answer.add(cnt);
        	}
        }
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String [] args) {
		int [] a = {1,2,3,2,3,1};
		System.out.println(Arrays.toString(solution(a)));
	}
}
