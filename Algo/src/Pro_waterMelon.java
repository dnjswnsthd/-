// 프로그래머스 코딩테스트 연습 수박수박?
public class Pro_waterMelon {
    public static String solution(int n) {
        String answer = "";
        String[] waterMelon = { "수", "박" };
        answer += "수";
        for(int i = 1; i < n; i++){
            answer += waterMelon[i % 2];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
