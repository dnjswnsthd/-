// 프로그래머스 코딩테스트 연습 문자열 내 p와 y의 개수
public class Pro_pyNum {
    static boolean solution(String s) {
        int pN = 0, yN = 0;
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p') pN++;
            else if(s.charAt(i) == 'y') yN++;
        }
        if(pN == yN) return true;
        return false;
    }
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }
}
