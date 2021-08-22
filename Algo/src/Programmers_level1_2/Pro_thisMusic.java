package Programmers_level1_2;

// ���α׷��ӽ� �ڵ��׽�Ʈ ���� ��ݱװ�

public class Pro_thisMusic {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] music = new String[musicinfos.length];
        String[][] mus = new String[musicinfos.length][4];
        int[] playTimes = new int[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            mus[i] = musicinfos[i].split(",");
        }
        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");
        for (int i = 0; i < musicinfos.length; i++) {
            mus[i][3] = mus[i][3].replaceAll("C#", "H");
            mus[i][3] = mus[i][3].replaceAll("D#", "I");
            mus[i][3] = mus[i][3].replaceAll("F#", "J");
            mus[i][3] = mus[i][3].replaceAll("G#", "K");
            mus[i][3] = mus[i][3].replaceAll("A#", "L");
        }
        for (int i = 0; i < musicinfos.length; i++) {
            int playTime = 0;
            // �� ���� ���� ���
            if (Integer.parseInt(mus[i][1].substring(3, 5)) >= Integer.parseInt(mus[i][0].substring(3, 5))) {
                playTime += Integer.parseInt(mus[i][1].substring(3, 5)) - Integer.parseInt(mus[i][0].substring(3, 5));
            } else {
                playTime -= Integer.parseInt(mus[i][0].substring(3, 5)) - Integer.parseInt(mus[i][1].substring(3, 5));
            }
            // �ð� ���� ���� ���(00:00 �Ѿ�� ��� ���� ������ �� ��츸 Ȯ�� �ϸ� ��)
            if (Integer.parseInt(mus[i][1].substring(0, 2)) > Integer.parseInt(mus[i][0].substring(0, 2))) {
                playTime += (Integer.parseInt(mus[i][1].substring(0, 2)) - Integer.parseInt(mus[i][0].substring(0, 2)))
                        * 60;
            }
            playTimes[i] = playTime;
            // ����Ǵ� �ð���ŭ�� ��µǴ� ������ music�� �����Ѵ�.
            String tmpS = "";
            if (playTime >= mus[i][3].length()) {
                for (int j = 0; j < playTime / mus[i][3].length(); j++) {
                    tmpS += mus[i][3];
                }
            }
            tmpS += mus[i][3].substring(0, playTime % mus[i][3].length());
            music[i] = tmpS;
            System.out.println(music[i]);
        }
        // m�� ������ ������ �ð��� ���� �� ������ ������ answer�� ��´�.
        int tmpPlayTime = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            if (music[i].contains(m) && playTimes[i] > tmpPlayTime) {
                tmpPlayTime = playTimes[i];
                answer = mus[i][2];
            }
        }
        if (tmpPlayTime == 0) {
            return "(None)";
        }
        return answer;
    }
    public static void main(String[] args) {
        String m = "A#";
        String[] musicinfos = {"13:00,13:02,HAPPY,BA#"};
        System.out.println(solution(m, musicinfos));
    }
}
