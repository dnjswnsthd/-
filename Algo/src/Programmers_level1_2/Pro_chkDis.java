package Programmers_level1_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 코딩테스트연습 거리두기 확인하기

public class Pro_chkDis {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for(int i = 0; i < places.length; i++){
            result[i] = isCorrext(places[i]);
        }
        return result;
    }
    
    public static int isCorrext(String[] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'P') { 
                    if(!bfs(board, i, j)) return 0; 
                }
            }
        }
        return 1;
    }
    
    public static boolean bfs(String[] board, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board.length];
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length)
                    continue;
                if (visited[nx][ny] || manhattan > 2)
                    continue;

                visited[nx][ny] = true;
                if (board[nx].charAt(ny) == 'X')
                    continue;
                else if (board[nx].charAt(ny) == 'P')
                    return false;
                else
                    q.offer(new Node(nx, ny));
            }
        }
        return true;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
        System.out.println(Arrays.toString(solution(places)));
    }
}
