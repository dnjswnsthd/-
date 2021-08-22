package BOJ;

import java.util.*;
public class BOJ4673 {
	static int check[] = new int[10036];
	public static void main(String args[]){
		for(int n = 1; n <= 10000; n++){
			check[d(n)] = 1;
			if(check[n]!=1)
				System.out.println(n);
		}
	}
	static int d(int n){
		int temp = n;
		if(n >= 10000){temp += n / 10000;n %= 10000;}
		if(n >= 1000){temp += n / 1000;n %= 1000;}
		if(n >= 100){temp += n / 100;n %= 100;}
		if(n >= 10){temp += n /10;n %= 10;}
		temp += n;
		return temp;
	}
}