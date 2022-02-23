package 그래프.가장먼노드_220223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,edge,maxdep; // 노드 개수,간선 개수
	static boolean[][] ar;
	static boolean[] num;
	static int[] depth;
	static Queue<node> queue = new LinkedList<node>();
	//1번 노드에서 가장 멀리 떨어진 노드의 개수를 찾고자 함
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		ar = new boolean[n+1][n+1];
		num = new boolean[n+1];
		System.out.println(num.length);
		depth = new int[n+1];
		for (int i = 1; i <= edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ar[start][end] = true;
			ar[end][start] = true;
		} // 간선 연결
		
		//1에서 출발해서 연결된 모든 노드를 탐색
//		System.out.println(bfs());
		bfs();
		System.out.println(depth[maxdep]);
	}
	static void bfs() {
		queue.offer(new node(1,0));
		num[1] =true;
		while(!queue.isEmpty()) {
			node val = queue.poll();
			maxdep = Math.max(maxdep, val.d);
			for (int i = 1; i <= n; i++) {
				if(i == val.n) continue;
				if(ar[val.n][i] && !num[i]) {
					queue.offer(new node(i,val.d+1));
					num[i] = true;
					depth[val.d+1]++;
				}
			}
		}
	}
	
	static class node {
		int n;
		int d;
		public node(int n, int d) {
			super();
			this.n = n;
			this.d = d;
		}
		
	}
}
