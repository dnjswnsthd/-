import java.util.Scanner;
import java.util.Stack;
 
public class SWEA1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] arr;
        for(int t = 1; t <= 10; t++) {
            Stack<Character> stack_fir = new Stack<>();
            Stack<Character> stack_sec = new Stack<>();
            Stack<Character> stack_thi = new Stack<>();
            Stack<Character> stack_fou = new Stack<>();
             
            int size = sc.nextInt();
            arr = new char[size];
             
            String str = sc.next();
            for(int i = 0; i < size; i++) {
                arr[i] = str.charAt(i);
                if(arr[i] == '{') stack_fir.push(arr[i]);
                else if(arr[i] == '[') stack_sec.push(arr[i]);
                else if(arr[i] == '(') stack_thi.push(arr[i]);
                else if(arr[i] == '<') stack_fou.push(arr[i]);
                else if(arr[i] == '}') {
                    if(!stack_fir.isEmpty()) {
                        stack_fir.pop();
                    }else break;
                }else if(arr[i] == ']') {
                    if(!stack_sec.isEmpty()) {
                        stack_sec.pop();
                    }else break;
                }else if(arr[i] == ')') {
                    if(!stack_thi.isEmpty()) {
                        stack_thi.pop();
                    }else break;
                }else if(arr[i] == '>') {
                    if(!stack_fou.isEmpty()) {
                        stack_fou.pop();
                    }else break;
                }
            }
            if(stack_fir.size() == 0 && stack_sec.size() == 0 && stack_thi.size() == 0 && stack_fou.size() == 0) {
                System.out.println("#" + t + " " + 1);
            }else {
                System.out.println("#" + t + " " + 0);
            }
        }
        sc.close();
    }
}