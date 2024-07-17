import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, size;
	static int y,x;
	static int y2,x2;
	static int[] dx = {1,2, 2, 1,-1,-2,-2,-1};
	static int[] dy = {2,1,-1,-2,-2,-1, 1, 2};
//	static int[][] ar;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) 
		{
			
			size = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
//			ar = new int[size][size];
			visited = new boolean[size][size];
			
			st = new StringTokenizer(br.readLine());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			if(y == y2 && x == x2) {
				System.out.println(0);
				continue;
			}
			
			
			System.out.println(bfs());
		}
		
	}

	
	static int bfs() {
		int cnt = 0;
		
		q.offer(new Node(y,x,0));
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny < 0 || ny >= size || nx < 0 || nx >= size || visited[ny][nx]) continue; 
				
				if(ny == y2 && nx == x2) {
					q.clear();
					cnt = n.cnt+1;
					break;
				}
				
				visited[ny][nx] = true;
				q.offer(new Node(ny,nx, n.cnt+1));
			}
			
		}
		
		
		return cnt;
		
	}
	
	static class Node {
		int y;
		int x;
		int cnt;
		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
		
	}
}
