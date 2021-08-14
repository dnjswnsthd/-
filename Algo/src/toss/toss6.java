package toss;

public class toss6 {
    public static long solution(int numOfStairs) {
        long answer = 0;
        long[] staris = new long [numOfStairs];
        if (numOfStairs == 1)
            return 1;
        else if (numOfStairs == 2)
            return 2;
        else if (numOfStairs == 3)
            return 4;
        staris[0] = 1;
        staris[1] = 2;
        staris[2] = 4;
        for (int i = 3; i < numOfStairs; i++) {
            staris[i] = staris[i - 3] + staris[i - 2] + staris[i - 1];
        }
        return staris[numOfStairs - 1];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }
}
