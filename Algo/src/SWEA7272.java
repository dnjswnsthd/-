import java.util.*;
 
public class SWEA7272 {
    static char[] one = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
    static char[] two = {'A','D','O','P','Q','R'};
    static char[] three = {'B'};
     
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            String a = sc.next();
            String b = sc.next();
            int flag = 1;
            int a_s;
            int b_s;
             
            if(a.length() != b.length()) {
                flag = 0;
            }
            else {
                for(int i = 0; i < ((a.length() < b.length()) ? a.length() : b.length()); i++) {
                    a_s = 0;
                    b_s = 0;
                    for(int j = 0; j < one.length; j++) {
                        if(a.charAt(i) == one[j])
                            a_s = 1;
                        if(b.charAt(i) == one[j])
                            b_s = 1;
                    }
                    for(int j = 0; j < two.length; j++) {
                        if(a.charAt(i) == two[j])
                            a_s = 2;
                        if(b.charAt(i) == two[j])
                            b_s = 2;
                    }
                    for(int j = 0; j < three.length; j++) {
                        if(a.charAt(i) == three[j])
                            a_s = 3;
                        if(b.charAt(i) == three[j])
                            b_s = 3;
                    }
                    if(a_s != b_s) {
                        flag = 0;
                        break;
                    }
                }
            }
            if(flag == 0) {
                System.out.println("#" + t + " " + "DIFF");
            }else {
                System.out.println("#" + t + " " + "SAME");
            }
        }
    }
}