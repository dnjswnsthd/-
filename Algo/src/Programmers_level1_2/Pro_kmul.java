package Programmers_level1_2;
import java.util.*;
/*
* 프로그래머스 > 2022카카오 > k진수에서 소수 개수 구하기
* 22.03.17
 */
class Pro_kmul {
    public int solution(int n, int k) {
        int answer = 0;
        String temp="";
        // N吏꾨쾿 蹂��솚
        while(n!=0){
            temp=n%k+temp;
            n/=k;
        }
        String[] arr = temp.split("0");
        for(String data: arr){
            if(data.equals("")) continue;
            long num=Long.parseLong(data);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    // �냼�닔
    public boolean isPrime (long a){
        if(a<2) return false;
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}