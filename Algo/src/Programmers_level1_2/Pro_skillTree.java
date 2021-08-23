package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ��ųƮ��

public class Pro_skillTree {
    public static int solution(String skill, String[] skillTrees) {
        int answer = 0;
        for (String sk : skillTrees) {
            String tmp = sk;
            for (int i = 0; i < sk.length(); i++) {
                String s = sk.substring(i, i + 1);
                if (!skill.contains(s))
                    tmp = tmp.replace(s, "");
            }
            if (skill.indexOf(tmp) == 0)
                answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = { "BACDE", "CBADF", "AECB", "BDA" };
        System.out.println(solution(skill, skillTrees));
    }
}
