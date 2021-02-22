import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1026 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sizeOfArray = sc.nextInt();
		int [] arrayA = new int[sizeOfArray];
		Integer [] arrayB = new Integer[sizeOfArray];
		for(int i = 0; i < sizeOfArray; i++) {
			arrayA[i] = sc.nextInt();
		}
		for(int i = 0; i < sizeOfArray; i++) {
			arrayB[i] = sc.nextInt();
		}
		Arrays.sort(arrayA);
		Arrays.sort(arrayB, Collections.reverseOrder());
		
		int [] result = new int[sizeOfArray];
		int sum = 0;
		for(int j = 0; j < sizeOfArray; j++) {
			result[j] = arrayA[j] * arrayB[j];
			sum += result[j];
		}
		System.out.print(sum);
	}
}
