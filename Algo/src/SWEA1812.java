import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class SWEA1812 {
    public static void main(String [] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList <Integer> tile = new ArrayList <>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int len = Integer.parseInt(st.nextToken());
                tile.add((int) Math.pow(2,  len));
            }
            tile.sort(Comparator.reverseOrder());
            System.out.println("#" + t + " " + tileNum(n, m , tile));
        }
    }
    private static int tileNum(int n, int m, ArrayList<Integer> tile) {
        int res = 0;
        ArrayList<Pair> p = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int target = tile.get(i);
            boolean add = true;
            int size = p.size();
            for(int j = 0; j < size; j++) {
                Pair tmp = p.get(j);
                if(tmp.w - target >= 0 && tmp.h - target >= 0) {
                    add = false;
                    if(tmp.h - target > 0 && target > 0)
                        p.add(new Pair(target, tmp.h - target));
                    if(tmp.h > 0 && tmp.w - target > 0)
                        p.add(new Pair(tmp.w - target, tmp.h));
                    p.remove(j);
                    break;
                }
            }
            if(add) {
                res++;
                p.add(new Pair(target, m - target));
                p.add(new Pair(m-target, m));
            }
        }
        return res;
    }
    static class Pair{
        int w, h;
        public Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}