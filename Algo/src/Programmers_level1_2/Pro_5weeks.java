package Programmers_level1_2;
// ���α׷��ӽ� �ڵ��׽�Ʈ ���� 5����
public class Pro_5weeks {
    public static int solution(String word) {
        int answer = 0;
        int tmp = 781;
        char[] words = { 'A', 'E', 'I', 'O', 'U' };
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (word.charAt(i) == words[j]) {
                    answer += 1 + (j * tmp);
                }
            }
            tmp = (tmp - 1) / 5;
        }
        return answer;
    }
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }
}