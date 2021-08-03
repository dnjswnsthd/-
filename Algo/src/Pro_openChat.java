import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// 프로그래머스 level2 오픈채팅방
public class Pro_openChat {
    public static String [] solution(String [] record) {
        ArrayList<String> chat = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        for (String history : record) {
            StringTokenizer st = new StringTokenizer(history);
            String operation = st.nextToken();
            String uid = st.nextToken();
            String name = "";
            if (!operation.equals("Leave")) {
                name = st.nextToken();
            }
            if (operation.equals("Enter")) {
                user.put(uid, name);
                chat.add(uid + "님이 들어왔습니다.");
            } else if (operation.equals("Leave")) {
                chat.add(uid + "님이 나갔습니다.");
            } else {
                user.put(uid, name);
            }
        }
        String[] answer = new String[chat.size()];
        int idx = 0;
        for(String str : chat){
            int end = str.indexOf("님");
            String userId = str.substring(0, end);
            answer[idx++] = str.replace(userId, user.get(userId));
        }
        return answer;
    }
    public static void main(String [] args){
        String [] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(solution(a));
    }
}
