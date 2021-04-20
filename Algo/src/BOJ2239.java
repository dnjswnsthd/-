import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class BOJ2239 {
    static int[][] maps;
    static ArrayList <Pair> checkList = new ArrayList<>();
    public static boolean dfs(int startPoint){
        if(startPoint==checkList.size())
            return true;
        int lowX;
        int lowY;
        int edgeX;
        int edgeY;
        int[] flag = new int[10];
        int x=checkList.get(startPoint).x;
        int y=checkList.get(startPoint).y;
        for(int i=0;i<9;i++){
            if(maps[x][i]!=0){
                flag[maps[x][i]]=1;
            }
        }
        for(int i=0;i<9;i++){
            if(maps[i][y]!=0){
                flag[maps[i][y]]=1;
            }
        }
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            lowX=0;lowY=0;edgeX=2;edgeY=2;
        } else if (x >= 3 && x <= 5 && y >= 0 && y <= 2) {
            lowX=3;lowY=0;edgeX=5;edgeY=2;
        } else if (x >= 6 && x <= 8 && y >= 0 && y <= 2) {
            lowX=6;lowY=0;edgeX=8;edgeY=2;
        } else if (x >= 0 && x <= 2 && y >= 3 && y <= 5) {
            lowX=0;lowY=3;edgeX=2;edgeY=5;
        } else if (x >= 3 && x <= 5 && y >= 3 && y <= 5) {
            lowX=3;lowY=3;edgeX=5;edgeY=5;
        } else if (x >= 6 && x <= 8 && y >= 3 && y <= 5) {
            lowX=6;lowY=3;edgeX=8;edgeY=5;
        } else if (x >= 0 && x <= 2 && y >= 6 && y <= 8) {
            lowX=0;lowY=6;edgeX=2;edgeY=8;
        } else if (x >= 3 && x <= 5 && y >= 6 && y <= 8) {
            lowX=3;lowY=6;edgeX=5;edgeY=8;
        } else{
            lowX=6;lowY=6;edgeX=8;edgeY=8;
        }
        for(int i=lowX;i<=edgeX;i++){
            for(int j=lowY; j<=edgeY;j++){
                if(maps[i][j]!=0){
                    flag[maps[i][j]]=1;
                }
            }
        }
        for(int i=1;i<10;i++){
            if(flag[i]==0){
                maps[x][y]=i;
                boolean bool = dfs(startPoint+1);
                if(bool){
                    return true;
                }
                maps[x][y]=0;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maps = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                maps[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(maps[i][j]==0){
                    checkList.add(new Pair(i,j));
                }
            }
        }
        dfs(0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(Integer.toString(maps[i][j]));
            }
            System.out.println();
        }
    }
}
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
