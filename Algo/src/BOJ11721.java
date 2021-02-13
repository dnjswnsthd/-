import java.util.Scanner;

public class BOJ11721{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String word = input.nextLine();
		int count = word.length() / 10;
		
		int control = 0;
		
		for(int i = 1; i <= count; i++){
			while(control < i * 10){
				System.out.print(word.charAt(control));
				control++;
			}
			System.out.println();
		}
		while(control < word.length()){
			System.out.print(word.charAt(control));
			control++;
		}
		System.out.println();
		input.close();
	}
}