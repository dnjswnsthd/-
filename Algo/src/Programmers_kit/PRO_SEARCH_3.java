package Programmers_kit;

import java.util.Arrays;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ����Ž�� ī��

public class PRO_SEARCH_3 {
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
		int width = 0, height = 3;
    	while(true) {
        	if(sum % height == 0) {
        		width = sum / height;
        		if(yellow == (width-2) * (height-2)) {
        			answer[0] = width;
        			answer[1] = height;
        			break;
        		}
        	}
        	height++;
        }
        return answer;
    }
	public static void main(String [] args) {
		int a = 24;
		int b = 24;
		System.out.println(Arrays.toString(solution(a, b)));
	}
}	
