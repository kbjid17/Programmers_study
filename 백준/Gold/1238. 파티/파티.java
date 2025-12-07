import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static ArrayList<int[]>[] list;
	static int[][] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		ar = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				ar[i][j] = Integer.MAX_VALUE;
				if(i == 0 || j == 0) ar[i][j] = -1; // 0번은 조회하지 않음
				if(i == j) ar[i][j] = 0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());	// start
			int g = Integer.parseInt(st.nextToken());	// goal
			int d = Integer.parseInt(st.nextToken());	// dist
			
			list[s].add(new int[] {g,d});
		}
		
		dijkstra();

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i <= N; i++) {
			ans = Math.max(ans, ar[i][X] + ar[X][i]);
		}
		System.out.println(ans);
		
		
	}
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			pq.offer(new int[] {i, 0});
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int now = cur[0];
				int cost = cur[1];
				if(ar[i][now] < cost) continue;
				if(visited[now]) continue;
				
				visited[now] = true;
				for (int[] next : list[now]) {
					int nextNode = next[0];
					int nextCost = cost + next[1];
					
					if(nextCost < ar[i][nextNode]) {
						ar[i][nextNode] = nextCost;
//						ar[i][nextNode] = nextCost; 
						pq.offer(new int[] {nextNode, nextCost});
					}
				}
				
			}
		}
	}
}