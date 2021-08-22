package Programmers_kit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 프로그래머스 코딩테스트 연습 해시 베스트 앨범

public class PRO_HASH_4 {
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap <String, Integer> musicMap = new HashMap<>();
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
        for(int i = 0; i < genres.length; i++) {
        	musicMap.put(genres[i], musicMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> arrSort = new ArrayList<String>(musicMap.keySet());
        Collections.sort(arrSort, (o1, o2) -> (musicMap.get(o2).compareTo(musicMap.get(o1))));
        for(int i = 0; i < arrSort.size(); i++) {
        	String tmp = arrSort.get(i);
        	int max = Integer.MIN_VALUE;
        	int first = 0;
        	int second = 0;
        	for(int j = 0; j < genres.length; j++) {
        		if(tmp.equals(genres[j])) {
        			if(plays[j] > max) {
        				max = plays[j];
        				first = j;
        			}
        		}
        	}
        	max = Integer.MIN_VALUE;
        	for(int j = 0; j < genres.length; j++) {
        		if(tmp.equals(genres[j])) {
        			if(j != first && plays[j] > max) {
        				max = plays[j];
        				second = j;
        			}
        		}
        	}
        	arrAnswer.add(first);
        	if(max != Integer.MIN_VALUE) arrAnswer.add(second);
        }
        return arrAnswer.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String [] args) {
		String [] a = {"classic", "pop", "classic", "classic", "pop"};
		int [] b = {500, 600, 150, 800, 2500};		
	}
}
