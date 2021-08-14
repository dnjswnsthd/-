package toss;

public class toss3 {
    public static boolean solution(String amountText) {
        String str = "0123456789,";
        if (amountText.charAt(0) == '0' || amountText.charAt(0) == ',' || amountText.charAt(amountText.length()-1) == ',')
            return false;
        for (int i = 0; i < amountText.length(); i++) {
            if (!str.contains(String.valueOf(amountText.charAt(i)))){
                return false;
            }
        }
        String[] s = amountText.split(",");
        if (s.length >= 1) {
            for (int i = 1; i < s.length; i++) {
                if (s[i].length() != 3)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String amountText = "25,2000,312";
        System.out.println(solution(amountText));
    }
}
