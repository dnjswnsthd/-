package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class BOJ1208 {
	static int N, S;
	static long cnt;
	static ArrayList<Integer> lList = new ArrayList<>();
	static ArrayList<Integer> rList = new ArrayList<>();
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		makeSum(0, 0, N/2, lList);
		makeSum(0, N/2, N, rList);
		Collections.sort(lList);
		Collections.sort(rList);
		cnt = 0;
		calcC();
		if(S == 0) {
			System.out.println(cnt - 1);
		}else {
			System.out.println(cnt);
		}
	}
	private static void calcC() {
		int pointerL = 0;
		int pointerR = rList.size()-1;
		
		while(true) {
			if(pointerL == lList.size() || pointerR < 0) {
				break;
			}
			int lv = lList.get(pointerL);
			int rv = rList.get(pointerR);
			if(lv + rv == S) {
				long lc = 0;
				while(pointerL < lList.size() && lList.get(pointerL) == lv) {
					lc++;
					pointerL++;
				}
				
				long rc = 0;
				while(0 <= pointerR && rList.get(pointerR) == rv) {
					rc++;
					pointerR--;
				}
				cnt += lc * rc;
			}
			if(lv + rv > S) {
				pointerR--;
			}
			if(lv + rv < S) {
				pointerL++;
			}
		}
	}
	private static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
		if(start == end) {
			list.add(sum);
			return;
		}
		makeSum(sum, start+1, end, list);
		makeSum(sum+arr[start], start+1, end, list);
	}
 
}