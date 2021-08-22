package SWEA;

import java.util.LinkedList;
import java.util.Scanner;
 
public class SWEA1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for(int t = 1; t <= 10; t++) {
            int encry_len = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < encry_len ; i++) {
                list.add(sc.nextInt());
            } 
 
            int oper = sc.nextInt();
            for(int i = 0; i < oper; i++) {
                String in = sc.next();
                int idx = sc.nextInt(); 
                int num  = sc.nextInt();
                for(int j = 0; j <num ; j++) {
                    list.add(idx, sc.nextInt());
                    idx++;
                }
            }
            System.out.printf("#%d ", t);
            for(int i = 0; i < 10; i ++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}