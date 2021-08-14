package toss;

public class toss4 {
    public static String solution(String input) {
        String answer = "";
        String[] s = input.split("\\n");
        int m = Integer.parseInt(String.valueOf(s[0].charAt(0)));
        int n = Integer.parseInt(String.valueOf(s[0].charAt(2)));
        int tmpM = m;
        int tmpN = n;
        boolean nega = true;
        answer += s[0] + "\n";
        for (int i = 1; i < s.length; i++) {
            if (s[i].equals("SHOW") && nega && tmpN != 0) {
                answer += 1 + "\n";
                tmpN--;
                tmpM = m;
            } else if (s[i].equals("SHOW")) {
                answer += 0 + "\n";
            } else if (s[i].equals("NEGATIVE")) {
                nega = false;
                answer += 0 + "\n";
            } else if (s[i].equals("NEXT")) {
                answer += "-\n";
                tmpM--;
                if (tmpM == -1) {
                    tmpM = m;
                    tmpN = n;
                    nega = true;
                }
            } else if (s[i].equals("EXIT")) {
                answer += "BYE";
                break;
            } else {
                answer += "ERROR\n";
            }
        }
        
        return answer;
    }
    public static void main(String[] args) {
        String input = "1 2\nSHOW\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nEXIT";
        System.out.println(solution(input));
    }
}
