// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ���ڿ� �� p�� y�� ����
public class Pro_pyNum {
    static boolean solution(String s) {
        int pN = 0, yN = 0;
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p') pN++;
            else if(s.charAt(i) == 'y') yN++;
        }
        if(pN == yN) return true;
        return false;
    }
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }
}
