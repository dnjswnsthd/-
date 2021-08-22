package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SWEA1824 {
    private static int x, y;
    private static int [] dx = {-1, 1, 0, 0};
    private static int [] dy = {0, 0, -1, 1};
    private static boolean res;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            char [][] map = new char[x][y];
            boolean escape = false; // @가 없을 수 있음.(미리 걸러줄 수 있다.)
            for(int i = 0; i < x; i++) {
                String str = br.readLine();
                for(int j = 0; j < y; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@') escape = true;
                }
            }
            // 위치와 상태에 대한 모든 정보를 포함. 4는 방향. 16은 0 ~15까지의 수
            boolean[][][][] visited = new boolean[x][y][4][16];
            res = false;
            if(escape) {
                Queue <Pair> que = new LinkedList<>();
                que.add(new Pair(0, 0, 3, 0));
                loop:while(!que.isEmpty()) {
                    Pair front = que.poll();
                    if(visited[front.x][front.y][front.dir][front.mem]) continue; //루프면 다른 길로 감
                    visited[front.x][front.y][front.dir][front.mem] = true;
                    switch(map[front.x][front.y]) {
                    case '@':
                        res = true;// 종료처리
                        break loop;// while문 벗어난다.
                    case '^':
                        front.dir = 0;
                        break;
                    case 'v':
                        front.dir = 1;
                        break;
                    case '<':
                        front.dir = 2;
                        break;
                    case '>':
                        front.dir = 3;
                        break;
                    case '_':
                        front.dir = (front.mem == 0 ? 3 : 2);
                        break;
                    case '|':
                        front.dir = (front.mem == 0 ? 1 : 0);
                        break;
                    case '?':// 4방처리
                        for(int i = 0; i < 4; i++) {
                            int nx = front.x + dx[i];
                            int ny = front.y + dy[i];
                            nx = (nx == map.length ? 0 : nx);
                            nx = (nx == -1 ? map.length -1 : nx);
                            ny = (ny == map[nx].length ? 0 : ny);
                            ny = (ny == -1 ? map[nx].length -1 : ny);
                            que.add(new Pair(nx, ny, i, front.mem));
                        }
                        continue;
                    case '.':// 아무것도 안한다.
                        break;
                    case '+':
                        front.mem = (front.mem == 15 ? 0 : front.mem + 1);
                        break;
                    case '-':
                        front.mem = (front.mem == 0 ? 15 : front.mem - 1);
                        break;
                    default://0 ~ 9 까지 숫자 메모리 저장
                        front.mem = map[front.x][front.y] - '0';
                        break;
                    }
                    // 새로운 상태 Pair 객체 큐에 추가
                    int nx = front.x + dx[front.dir];
                    int ny = front.y + dy[front.dir];
                    nx = (nx == map.length ? 0 : nx);
                    nx = (nx == -1 ? map.length -1 : nx);
                    ny = (ny == map[nx].length ? 0 : ny);
                    ny = (ny == -1 ? map[nx].length -1 : ny);
                    que.add(new Pair(nx, ny, front.dir, front.mem));
                }
            }
            sb.append("#").append(t).append(" ");
            sb.append((res == true) ? "YES" : "NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static class Pair{
        int x, y, dir, mem;
        public Pair(int x, int y, int dir, int mem) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mem = mem;
        }
    }
}