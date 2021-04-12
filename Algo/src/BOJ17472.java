import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17472 {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int map[][] = new int[r][c];
		for(int y = 0 ; y < r ; y ++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0 ; x < c ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		//단지 나누기 
		int mark = 1;
		int diry[] = {0,0,-1,1};
		int dirx[] = {-1,1,0,0};
		int temp=0,nexty=0,nextx=0;
		ArrayDeque<int []> dq = new ArrayDeque<>();
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] > o2[2])return 1;
				else return -1;
			}
		});
		for(int y = 0 ; y< r ; y++) {
			for(int x = 0 ; x < c ; x++) {
				if(map[y][x] == 1 ) {
					temp = map[y][x] +mark;
					map[y][x] = temp;
					dq.add(new int[] {y,x});
					while(!dq.isEmpty()) {
						int now[] = dq.poll();
						int ny = now[0] ,nx = now[1];
						for(int index = 0 ; index < 4; index++) {
						 nexty = ny + diry[index];
						 nextx = nx + dirx[index];
						 if(nexty >= 0 && nextx >= 0 && nexty < r && nextx < c && map[nexty][nextx] ==1 ){
							 map[nexty][nextx] = temp;
							 dq.add(new int[] {nexty , nextx});
						 	}
						}
					}
					mark++;
				}
			}
		}
		
		int len = 0;
		int target = 0;
		boolean com = false;
		for(int y = 0 ; y < r ; y ++) {
			for(int x= 0 ; x < c ; x++) {
				//퍼질수있는지 검사..
				if(map[y][x] > 0) {
					if( y-1 >=0 && map[y-1][x] == 0) {
						for(int ny = y-1 ; ny >=0 ; ny--){
							if(map[ny][x] ==0 )len++;
							else if(map[ny][x] != map[y][x]) {
								target = map[ny][x];
								com  = true;
								break;
							}
							else if(map[ny][x] == map[y][x]) break;
						}
						if(com && len >=2) pq.add(new int [] {map[y][x] , target , len});
						target = 0; len= 0; com = false;
					}
					
					if( y+1 < r  && map[y+1][x] == 0) {
						 for(int ny = y+1 ; ny < r  ; ny++ ){
							 	if(map[ny][x] ==0 )len++;
								else if(map[ny][x] != map[y][x]) {
									target = map[ny][x];
									com  = true;
									break;
								}
								else if(map[ny][x] == map[y][x]) break;
						}
						if(com && len >=2 ) pq.add(new int [] {map[y][x] , target , len});
						target = 0; len= 0; com = false;
					}
					
					if( x-1 >=0 && map[y][x-1] == 0) {
						for(int nx = x-1 ; nx >=0 ; nx--){
							if(map[y][nx] ==0 ) len++;
							else if(map[y][nx] != map[y][x]) {
								target = map[y][nx];
								com  = true;
								break;
							}
							else if(map[y][nx] == map[y][x]) break;
						}

						if(com && len >=2) pq.add(new int [] {map[y][x] , target , len});
						target = 0; len= 0; com = false;
					}
				
					if( x+1  < c && map[y][x+1] == 0) {
						for(int nx = x+1 ; nx < c; nx++){
							if(map[y][nx] ==0 ) {
								len++;
							}
							else if(map[y][nx] != map[y][x]) {
								target = map[y][nx];
								com  = true;
								break;
							}
							else if(map[y][nx] == map[y][x]) {
								break;
							}
						}
						if(com && len >=2) pq.add(new int [] {map[y][x] , target , len});
						target = 0; len= 0; com = false;
					}
				}
			}
		}
		boolean isfullcheck = false;
		int res = 0; mark++;
		ArrayList<int []> node[];
		node = new ArrayList[mark];
		for(int index = 0 ; index < mark ; index++) node[index] = new ArrayList<int []>();
		ArrayDeque<Integer> dq2 = new ArrayDeque<>();
		while(!pq.isEmpty()) {
			int now[] = pq.poll();
			int start = now[0], end = now[1], length = now[2];
			boolean s = node[start].contains(end) , e = node[end].contains(start);
			boolean visit[] = new boolean[mark];
			if(!s&& !e) {
				node[start].add(new int[] {end,length});
				node[end].add(new int[] {start,length});
			}
			else if(s && !e) {node[end].add(new int [] {start,length});}
			else if(!s && e) {node[start].add(new int[] {end,length});} 
			//연결성 검사
			dq2.add(start);
			visit[start] = true;
			res = 0;
			while(!dq2.isEmpty()) {
				int posnow = dq2.poll();
				int size = node[posnow].size();
				for(int index = 0 ; index < size; index++) {
					if(!visit[node[posnow].get(index)[0]]) {
						visit[node[posnow].get(index)[0]] = true;
						dq2.add(node[posnow].get(index)[0]);
						res +=node[posnow].get(index)[1];
					}
				}
			}
			//다연결되었는지?
			if(isfull(visit)) {
				isfullcheck = true;
				break;
			} 
		}
		if(!isfullcheck || res == 0) res = -1;
		System.out.println(res);
	}
	public static boolean isfull(boolean[] visit) {
		int size = visit.length;
		for(int index = 2; index < size ; index++)if(!visit[index]) return false;
		return true;
	}
	
}