package Programmers_level3;

import java.util.Arrays;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� �߱� ����

public class Pro_work {
    public static long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;
        for(int i=0; i<works.length; i++)
            sum += works[i];
        if(n >= sum) 
            return 0;
        while(n != 0) {
            int max = 0;
            for(int i=0; i<works.length; i++) 
                if(works[i] > max)	max = works[i];
            for(int i=0; i<works.length; i++) {
                if(works[i] == max) {
                    works[i] --;
                    n --;
                    if(n == 0)	break;
                }
            }
        }
        for(int i=0; i<works.length; i++) {
            answer += (works[i] * works[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] works = { 4, 3, 3 };
        int n = 4;
        System.out.println(solution(n, works));
    }
}
