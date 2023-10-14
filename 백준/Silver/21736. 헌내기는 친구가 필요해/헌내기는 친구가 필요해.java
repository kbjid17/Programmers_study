import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] ar;
	static boolean[][] visited;
	static Queue<node> q  =new LinkedList<node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		
		ar = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			ar[i] = br.readLine().toCharArray();
			for (int j = 0; q.isEmpty() && j < M; j++) {
				if(ar[i][j] == 'I') {
					q.offer(new node(i,j));
					break;
				}
			}
		}
		bfs();

	}
	
	static void bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			node n = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || ar[ny][nx] == 'X' || ar[ny][nx] == 'I') continue;
				visited[ny][nx] = true;
				if(ar[ny][nx] == 'P') cnt++;
				q.offer(new node(ny,nx));
				
			}
		}
		
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}
	
	static class node {
		int y;
		int x;
		public node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
