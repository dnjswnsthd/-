package Programmers_kit;

import java.util.HashMap;

// 프로그래머스 코딩테스트 연습 해쉬 전화번호 목록

public class PRO_HASH_2 {
	public static boolean solution(String[] phone_book) {
		HashMap <String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                        return false;
                }
            }
        }
            return true;
    }
	
	
//	public boolean solution(String[] phone_book) {
//		for(int i = 0; i < phone_book.length-1; i++) {
//			for(int j = i + 1; j < phone_book.length; j++) {
//				if(phone_book[i].startsWith(phone_book[j]))return false;
//				if(phone_book[j].startsWith(phone_book[i]))return false;
//			}
//		}
//        return true;
//    }
}
