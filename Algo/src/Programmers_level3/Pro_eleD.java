import java.util.LinkedList;
import java.util.Queue;
/*
* 프로그래머스 > 기지국 설치
* 22.04.15
 */
class Pro_eleD {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        Queue<Integer> sq = new LinkedList<Integer>();
        for(int s : stations) {
            sq.offer(s);
        }
        int position = 1;
        while(position <= n) {
            if(!sq.isEmpty() && position >= sq.peek() - w) {
                position = sq.poll() + w + 1;
            }
            else {
                answer += 1;
                position += (w*2) + 1;
            }
        }
        return answer;
    }
}