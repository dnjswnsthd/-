import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * BOJ 10927
 * 22.05.14
 */
public class BOJ10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        sb.append(str).append("??!");
        System.out.println(sb);
    }
}