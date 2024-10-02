import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node {
	int y;
	int x;
	int k; // 말 이동이 가능한 횟수
	int c; // 원숭이가 현재까지 이동한 횟수
	public node(int y,int x,int k,int c) {
		this.y = y;
		this.x = x;
		this.k = k;
		this.c = c;
	}
}

public class Main {
	static int K,H,W;
	static int[][] ar;
	static int min = Integer.MAX_VALUE;
	// 같은 y, x 이라도 말이동 횟수 남은 것에 따라 의미가 다를 수 있다.    
	static boolean[][][] visit;
	static int[] horsey = new int[] {-2,-1,1,2,2,1,-1,-2};
	static int[] horsex = new int[] {1,2,2,1,-1,-2,-2,-1};
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<node> q = new LinkedList<node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ar = new int[H][W];
		visit = new boolean[K+1][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0,0);
		
	}
	static void bfs(int ynum,int xnum) {
		visit[0][ynum][xnum] = true;
		q.offer(new node(ynum,xnum,0,0));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			//원숭이의 이동 후의 정보가 있었으면 함
			// 말 이동을 한 횟수라던지
			// 해당 위치에서 말 이동을 한 경우의 좌표랑 그냥 이동을 한 경우의 좌표가 모두 필요
			if(n.y == H-1 && n.x == W-1)
			{
				System.out.println(n.c);
				return;
			}
			
			
			for (int i = 0; i < 4; i++) {
				int ny = n.y+dy[i];
				int nx = n.x+dx[i];
				if(ny < 0 || ny >= H || nx < 0 || nx >= W || ar[ny][nx] == 1 || visit[n.k][ny][nx]) continue;
					visit[n.k][ny][nx] = true;
					q.offer(new node(ny,nx,n.k,n.c+1));
				
			}
			if(n.k == K) continue; 
				for (int i = 0; i < 8; i++) {
					int kny = n.y+ horsey[i];
					int knx = n.x+ horsex[i];
					if(kny < 0 || kny >= H || knx < 0 || knx >= W || ar[kny][knx] == 1 || visit[n.k+1][kny][knx]) continue;
//						visit[n.k+1][n.y][n.x] = true; //말이 한번 이동한 차원으로 올라와서
						visit[n.k+1][kny][knx] = true; // 이동을 진행
						q.offer(new node(kny,knx,n.k+1,n.c+1));
					
				}
			
		}
		System.out.println(-1);
	}
}
