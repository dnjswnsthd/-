package talentX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class talentX3 {
    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < debts.size(); i++){
            if (map.containsKey(debts.get(i).get(0))) {
                map.replace(debts.get(i).get(0), map.get(debts.get(i).get(0)) - Integer.parseInt(debts.get(i).get(2)));
            } else {
                map.put(debts.get(i).get(0), -Integer.parseInt(debts.get(i).get(2)));
            }
            if (map.containsKey(debts.get(i).get(1))) {
                map.replace(debts.get(i).get(1), map.get(debts.get(i).get(1)) + Integer.parseInt(debts.get(i).get(2)));
            } else {
                map.put(debts.get(i).get(1), Integer.parseInt(debts.get(i).get(2)));
            }
        }
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int min = list.get(0).getValue();
        
        for (Entry<String, Integer> entry : list) {
            if (min == entry.getValue()) {
                answer.add(entry.getKey());
            } else {
                break;
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
    public static void main(String[] args) {
        
    }
}
