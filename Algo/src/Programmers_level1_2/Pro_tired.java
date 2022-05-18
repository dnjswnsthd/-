package Programmers_level1_2;
/*
* 코딩테스트 연습 > 위클리 챌린지 > 피로도
* 2022-03-10
* 깊이 우선 탐색을 통해 최대 던전 수를 갱신하는 방식
 */
class Pro_tired {
    public static int answer = 0;
    public static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public static void dfs(int dep, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dep + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, dep);
    }

    public static void main(String args[]) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println("sol : " + solution(80, dungeons));
    }
}