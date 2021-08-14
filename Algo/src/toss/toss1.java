package toss;

public class toss1 {
    public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        orderAmount -= taxFreeAmount;
        orderAmount -= serviceFee;
        double d = (double)orderAmount / 10;
        System.out.println(d);
        long answer = Math.round(d);
        return answer;
    }
    public static void main(String[] args) {
        long a = 125;
        long b = 10;
        long c = 10;
        System.out.println(solution(a, b, c));
    }
}
