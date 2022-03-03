package Programmers_level1_2;
/*
* 코딩테스트 연습 > 위클리 챌린지 > 최소직사각형
* 2022-03-03
*/
public class Pro_minSqu {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int w[] = new int[len];
        int h[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                w[i] = sizes[i][1];
                h[i] = sizes[i][0];
            } else {
                w[i] = sizes[i][0];
                h[i] = sizes[i][1];
            }
        }
        int maxW = 0, maxH = 0;
        for (int i = 0; i < len; i++) {
            maxW = Math.max(maxW, w[i]);
            maxH = Math.max(maxH, h[i]);
        }
        return maxW * maxH;
    }
}
