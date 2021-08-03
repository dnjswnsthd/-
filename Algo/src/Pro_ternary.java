// 프로그래머스 3진법 뒤집기
class Pro_ternary {
    public static int solution(int n) {
        String ternary = "";
        while (n != 0) {
            if ((n % 3) < 10) {
                ternary = (n % 3) + ternary;
                n /= 3;
            }
        }
        int answer = 0;
        int tmp = 1;
        for (int i = 0; i < ternary.length(); i++) {
            answer += Integer.parseInt(ternary.charAt(i) + "") * tmp;
            tmp *= 3;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}