package q2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N,K, count;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static ArrayList<Integer> area = new ArrayList<>();
	static int[][] map;
	
	public static void DFS(int x, int y) {
		int i;
		int ax,ay;
		
		map[x][y] = 1;
		if(area.size() < count) area.add(0);
		
		area.set(count-1, area.get(count-1)+1);
		for(i=0;i<4;i++) {
			ax = x + dx[i];
			ay = y + dy[i];
			
			if(ax < 0 || ax >= M || ay < 0 || ay >= N) continue;
			if(map[ax][ay] == 1) continue;
			DFS(ax,ay);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int i,j,k;
		int l_x,l_y,h_x,h_y;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for(i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			l_x = Integer.parseInt(st.nextToken());
			l_y = Integer.parseInt(st.nextToken());
			h_x = Integer.parseInt(st.nextToken());
			h_y = Integer.parseInt(st.nextToken());
			
			for(j=l_y; j<h_y; j++) {
				for(k=l_x; k<h_x; k++) {
					map[j][k] = 1;
				}
			}
		}
		for(i=0; i<M; i++) {
			for(j=0; j<N; j++) {
				if(map[i][j] == 0) {
					count++;
					DFS(i,j);
				}
			}
		}
		System.out.println(count);
		
		Collections.sort(area);
		
		for(i=0;i<area.size();i++) {
			System.out.print(area.get(i)+" ");
		}
		
		
		in.close();
	}
}
