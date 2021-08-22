package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class SWEA1223 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            Stack<Integer> num = new Stack<Integer>();
            Stack<Character> oper = new Stack<Character>();
            int n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            char c[] = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (!Character.isDigit(c[i])) {
                    oper.push(c[i]);
                } else {
                    if (!oper.isEmpty() && oper.peek() == '*') {
                        num.push(num.pop() * (c[i] - '0'));
                        oper.pop();
                    } else
                        num.push(c[i] - '0');
                }
            }
            while (!oper.isEmpty()) {
                int a = num.pop();
                int b = num.pop();
                num.push(a + b);
                oper.pop();
            }
            System.out.println("#" + t + " " + num.peek());
        }
    }
}