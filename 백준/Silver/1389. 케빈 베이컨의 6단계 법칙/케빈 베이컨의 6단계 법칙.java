import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N,M; // 유저의 수, 친구 관계의 수
	static ArrayList<Integer>[] list = new ArrayList[101];
	static int[] ans = new int[] {0,Integer.MAX_VALUE};
	static int[] friend_size = new int[101];
	static int[][] friend_dist = new int[101][101];
	static boolean[][] visited = new boolean[101][101];
	static Queue<int[]> q = new LinkedList<int[]>();	// [탐색 번호 수][더해지는 가중치]
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i < 101; i++) {
			list[i] = new ArrayList<Integer>(); // 해당 유저가 가지는 친구의 목록을 기록
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
			friend_dist[a][b]++;
			friend_dist[b][a]++;
			//friend_size[a]++;
			//friend_size[b]++;
		}
		for (int i = 1; i <= N; i++) {			
			bfs(i);
		}
		for (int i = 1; i <= N; i++) {
			if(ans[1] > friend_size[i]) {
				ans[1] = friend_size[i];
				ans[0] = i;
			}
		}
		System.out.println(ans[0]);
	}
	static void bfs(int n) {
		q.offer(new int[] {n,1});
		
		while(!q.isEmpty()) {
			
			int[] node = q.poll();
			for (int i = 0; i < list[node[0]].size(); i++) {
				if(visited[n][list[node[0]].get(i)]) continue; // 이미 친구면 continue;
				
				// 친구의 친구 목록을 더함
				visited[n][list[node[0]].get(i)] = true;
				if((friend_dist[n][list[node[0]].get(i)]== 0) && n != list[node[0]].get(i)) {
					
					friend_dist[n][list[node[0]].get(i)] = node[1];
					friend_size[n] += node[1];
					friend_size[list[node[0]].get(i)] += node[1];
				}
				
				q.offer(new int[] {list[node[0]].get(i), node[1]+1});
			}
		}
	}
}