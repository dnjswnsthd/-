package Programmers_level1_2;

import java.util.Arrays;
import java.util.Comparator;
// 프로그래머스 코딩테스트 연습 [3차] 파일명 정렬
public class Pro_filenameSort {
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                int res = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (res == 0) {
                    res = findN(o1, head1) - findN(o2, head2);
                }
                return res;
            }

            private int findN(String s, String head) {
                s = s.replace(head, "");
                String res2 = "";
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c) && res2.length() < 5) {
                        res2 += c;
                    } else {
                        break;
                    }
                }
                return Integer.valueOf(res2);
            }
        });
        return files;
    }
    
    public static void main(String[] args) {
        String[] files = { "img12.png", "img10.png", "img02png", "img1.png", "IMG01.GIF", "img2.JGP" };
        System.out.println(Arrays.toString(solution(files)));
    }
}
