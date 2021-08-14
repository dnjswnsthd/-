package toss;

import java.util.Arrays;

public class toss2 {
    public static int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][requests.length / servers];
        if (!sticky) {
            for (int i = 0; i < requests.length; i++) {
                if(i == 0) answer[0][0] = requests[0];
                else
                    answer[i % servers][i/servers] = requests[i];
            }
        } else {
            for (int i = 0; i < requests.length; i++) {
                if (i == 0)
                    answer[0][0] = requests[0];
                else {
                    if (requests[i] == requests[i - 1]) {
                        if (i % servers == 0) {
                            answer[servers - 1][i / servers + 1] = requests[i];
                        } else {
                            answer[i % servers - 1][i / servers + 1] = requests[i];
                        }
                    } else {
                        answer[i % servers][i / servers] = requests[i];
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int servers = 2;
        boolean sticky = false;
        int[] requests = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(solution(servers, sticky, requests)));
    }
}
