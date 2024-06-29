import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static Queue<Node> q = new LinkedList<Node>(); // 상근이 queue
	static Queue<Node> qq = new LinkedList<Node>(); // 불 queue
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken()); // 너비
			int H = Integer.parseInt(st.nextToken()); // 높이
			
			char[][] ar = new char[H][W];
			int[][] fire = new int[H][W];
			boolean[][] visited = new boolean[H][W];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(ar[i][j] == '@') {
						q.offer(new Node(i,j,0));
					}
//					if(ar[i][j] == '*')
//						qq.offer(new Node(i,j,0)); // 불 : cnt가 1이면 생략, 0이면 이동하고 qq에 삽입
						
				}
			}
			int fire_cnt = 1;
			
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if(ar[i][j] == '*') {
							qq.offer(new Node(i,j,0));
//							fire[i][j] = 1;
						}
							
					}
				}
//				System.out.println("start");
				while(!qq.isEmpty()) {
					Node nn = qq.poll();
					
					for (int dd = 0; dd < 4; dd++) {
						int fy = nn.y + dy[dd];
						int fx = nn.x + dx[dd];
						
						if(fy < 0 || fy >= H || fx < 0 || fx >= W || ar[fy][fx] == '*' || ar[fy][fx] == '#') continue;
						qq.offer(new Node(fy, fx, nn.cnt+1));
//						System.out.println(fy + " " + fx);
						ar[fy][fx] = '*';
						fire[fy][fx] = nn.cnt+1;
					}
				}
				
//			for (int i = 0; i < H; i++) {
//				for (int j = 0; j < W; j++) {
//					System.out.print(fire[i][j]);
//				}
//				System.out.println();
//			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				Node n = q.poll();
				// 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다. : 
				// 불보다 상근이가 먼저 움직인다.
				//노드를 이동시키기 전에, 해당 칸이 불에 휩싸였는지 확인한다. 휩싸였으면 해당 노드는 버린다.
				
				
				if(ar[n.y][n.x] == '*' && fire[n.y][n.x] <= n.cnt) continue;
				for (int d = 0; d < 4; d++) {
					int ny = n.y + dy[d];
					int nx = n.x + dx[d];
					
					if(ny < 0 || ny >= H || nx < 0 || nx >= W) { // 탈출에 성공했으면
//						System.out.println(ny + " " + nx + " " + n.cnt);
						cnt = n.cnt+1;
						q.clear();
						break;
					}
					if(ar[ny][nx] == '#' || visited[ny][nx]) continue;
					
					q.offer(new Node(ny,nx, n.cnt+1));
					visited[ny][nx] = true;
					
				}

				
			}
			if(cnt == 0) 
				sb.append("IMPOSSIBLE").append("\n");
			else
				sb.append(cnt).append("\n");
			
			
		}
		
		System.out.println(sb.toString());
		

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
