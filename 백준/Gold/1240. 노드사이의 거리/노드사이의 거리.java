import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m; // 노드의 개수 n, 거리를 알고 싶은 노드 쌍의 개수 m
	static ArrayList<Integer>[] arlist;
	static int[][] ar;
	static Queue<Node> q = new LinkedList<Node>();
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arlist = new ArrayList[n+1];
		visited = new boolean[n+1];
		ar = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			arlist[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ar[a][b] = c;
			ar[b][a] = c;
			arlist[a].add(b);
			arlist[b].add(a);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			visited = new boolean[n+1];
			System.out.println(bfs(a,b));
		}
	}
	
	static int bfs(int a, int b) {
		int ans = 0;
		q.offer(new Node(a,0));
		visited[a] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			
			for (int i = 0; i < arlist[n.n].size(); i++) {
				if(visited[arlist[n.n].get(i)]) continue; // 방문한 경우 pass
				
				if(arlist[n.n].get(i) == b) { // 도착했을 경우
					ans = n.v + ar[n.n][b];
					q.clear();
				}
				else {
					q.offer(new Node(arlist[n.n].get(i), n.v + ar[n.n][arlist[n.n].get(i)]));
					
//					System.out.println(n.n+ " " + arlist[n.n].get(i) + " " + ar[n.n][arlist[n.n].get(i)]);
					visited[arlist[n.n].get(i)] = true;
				}
			}
			
		}
		return ans;
	}

	static class Node {
		int n; // 현재 위치
		int v; // 현재 가중치
		public Node(int n, int v) {
			super();
			this.n = n;
			this.v = v;
		}
	}
}