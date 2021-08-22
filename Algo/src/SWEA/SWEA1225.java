package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class SWEA1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            Queue <Integer> que = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
                que.offer(sc.nextInt());
            }
            int oper = 1;
            while(true) {
                int num = que.poll();
                num -= oper;
                oper++;
                if(oper == 6) oper = 1;
                if(num <= 0) num = 0;
                que.offer(num);
                if(num == 0) break;
            }
            System.out.print("#" + t + " ");
            while(!que.isEmpty()) {
                System.out.println(que.poll() + " ");
            }
            System.out.println();
        }
    }
}