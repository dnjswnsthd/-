// 프로그래머스 코딩테스트 연습 신규아이디 추천

public class Pro_newIdReco {

  public static String solution(String new_id) {
    new_id = new_id.toLowerCase();
    new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
    new_id = new_id.replaceAll("[.]{2,}", ".");
    new_id = new_id.replaceAll("^[.]|[.]$", "");
    if (new_id.length() == 0) return "aaa";
    if (new_id.length() > 15) {
      new_id = new_id.substring(0, 15);
      new_id = new_id.replaceAll("[.]$", "");
    }
    if (new_id.length() <= 2) {
      while (new_id.length() < 3) new_id =
        new_id + new_id.charAt(new_id.length() - 1);
    }
    return new_id;
  }

  public static void main(String[] args) {
    String id = "b......@";
    System.out.println(solution(id));
  }
}
