package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ6593 {
   static int dx[] = {-1,0,1,0,0,0};
   static int dy[] = {0,1,0,-1,0,0};
   static int dh[] = {0,0,0,0,1,-1};
   static char[][][]building;
   static boolean[][][] visit;
   static int L;
   static int R;
   static int C;
   static Queue <Person> que;
   static int visited_cnt;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while(true) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         L= Integer.parseInt(st.nextToken());
         R= Integer.parseInt(st.nextToken());
         C= Integer.parseInt(st.nextToken());
         if(L==0) {
            break;
         }
          
         building = new char[L][R][C];
         visit = new boolean[L][R][C];
         que = new LinkedList <Person> ();
         visited_cnt=0;
         for(int i=0;i<L;i++) {
            for(int j=0;j<R;j++) {
               String str= br.readLine();
               for(int k=0;k<C;k++) {
                  building[i][j][k]=str.charAt(k);
                  if(building[i][j][k]=='S') {
                     Person p =new Person(i,j,k,0);
                     que.add(p);
                  }
               }
            }
            br.readLine();
         }
         bfs();
         if(visited_cnt==0) {
            System.out.println("Trapped!");
         }
      }
   }
   static void bfs() {
      while(!que.isEmpty()) {
         Person temp = que.poll();
         int h = temp.h;
         int x = temp.x;
         int y= temp.y;
         int count= temp.count;
         for(int i=0;i<6;i++) {
            int rh = h+dh[i];
            int rx = x+dx[i];
            int ry = y+dy[i];
            if(rx<0||ry<0||rh<0||rx>=R||ry>=C||rh>=L) {
               continue;
            }
            if(building[rh][rx][ry]=='.'&&visit[rh][rx][ry]==false) {
               Person p = new Person(rh,rx,ry,count+1);
               visit[rh][rx][ry]=true;
               que.add(p);
            }else if(building[rh][rx][ry]=='E') {
            	visited_cnt++;
               count++;
               System.out.println("Escaped in "+count+" minute(s).");
               que.clear();
               break;
            }
         }
      }
   }
} 
class Person{
   int h;
   int x;
   int y;
   int count;
   Person(int h,int x, int y, int count) {
      this.h = h;
      this.x = x;
      this.y= y;
      this.count = count;
   }
}