package BOJ;

import java.util.HashMap;
import java.util.Scanner;
 
public class BOJ4195 {
    static int root[];  
    static int cnt[];   
    
    static int find(int x){
        if(root[x]==x)
            return x;
        else
            return root[x]=find(root[x]); 
    }
     
    static int merge(int p, int q){
        p=find(p);
        q=find(q);
        if(p!=q){                   
            root[q]=p;              
            cnt[p]+=cnt[q];         
            cnt[q]=1;               
        }
        return cnt[p];
    }
     
    public static void main(String args[]){
        int T;
        Scanner sc= new Scanner(System.in);
        T=sc.nextInt();
        for(int i=0;i<T;i++){    
            int N, idx1,idx2,num=0;
            N=sc.nextInt();
            root=new int[N*2];
            cnt=new int[N*2];
            HashMap<String,Integer>index = new HashMap<String,Integer>();  
            
            String str1, str2;
            for(int j=0;j<2*N;j++){  
                root[j]=j;
                cnt[j]=1;
            }
            for(int j=0;j<N;j++){
                str1=sc.next();
                str2=sc.next();
                if(index.containsKey(str1)==false) index.put(str1, num++);
                idx1=index.get(str1);
                if(index.containsKey(str2)==false) index.put(str2, num++);
                idx2=index.get(str2);
                int result=merge(idx1,idx2);
                System.out.println(result);
            }
        }
        sc.close();
    }
}
