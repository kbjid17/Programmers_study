import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static int[][] ans;
	static Queue<node> q = new LinkedList<node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar  = new int[N][M];
		ans = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 2) q.offer(new node(i,j,0));
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 1 && ans[i][j] == 0) ans[i][j] = -1;
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			node n = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || ans[ny][nx] != 0 || ar[ny][nx] != 1) continue;
				ans[ny][nx] = n.cnt+1;
				q.offer(new node(ny,nx,n.cnt+1));
			}
			
		}
	}

	static class node {
		int y;
		int x;
		int cnt;
		public node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
