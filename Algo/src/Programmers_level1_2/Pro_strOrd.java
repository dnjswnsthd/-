package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���ڿ� �ٷ�� �⺻
class Pro_strOrd {
    public static boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            if (s.toUpperCase().equals(s) && s.toLowerCase().equals(s))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "a234";
        System.out.println(solution(str));
    }
}