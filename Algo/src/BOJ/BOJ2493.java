package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int len = arr.length;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("0 ");
		int tmp = 0;
		stack.push(tmp);
		for (tmp = 1; tmp < len; tmp++) {
			while (true) {
				if (stack.isEmpty()) {
					sb.append("0 ");
					stack.push(tmp);
					break;
				} else {
					if (arr[stack.peek()] > arr[tmp]) {
						int top = stack.peek() + 1;
						sb.append(top + " ");
						
						stack.push(tmp);
						break;
					} else {
						stack.pop();
					}
				}
			}
		}
		System.out.print(sb);
	}
}