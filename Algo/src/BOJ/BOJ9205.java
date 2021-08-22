package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class BOJ9205 {
    static int N;    
    static int arr[][];
    static ArrayList<Point> arrList;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int tc=0; tc<testCases; tc++) {
            N = Integer.parseInt(br.readLine());
            
            arrList = new ArrayList<>();
            arr = new int[N+2][N+2];
            for(int i=0; i<N+2; i++)
                for(int j=0; j<N+2; j++)
                    arr[i][j]=999999;
            StringTokenizer st;
            for(int i=0; i<N+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arrList.add(new Point(x,y));
            }
            
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(i==j)
                        continue;    
                    Point current = arrList.get(i);
                    Point next = arrList.get(j); 
                    int dist = Math.abs(current.x-next.x)+Math.abs(current.y-next.y);
                    if(dist<=1000)
                        arr[i][j] = 1;
                }
            }
            floyd();
            if(0<arr[0][N+1] && arr[0][N+1]<999999)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
    public static void floyd() {
        for(int k=0; k<N+2; k++) {
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
    
}
 
