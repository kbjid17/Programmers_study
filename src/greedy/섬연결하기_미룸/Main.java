package greedy.섬연결하기_미룸;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] cost;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		parents = new int[n+1];
		make();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
static void make() {
	for (int i = 1; i <= n; i++) {
		parents[i] = i;
	}
}

static int find(int a) {
	if(a == parents[a]) return a;
	return parents[a] = find(parents[a]);
}

static boolean union(int a,int b) {
	int aRoot = find(a);
	int bRoot = find(b);
	if(aRoot == bRoot) return false;
	
	parents[bRoot] = aRoot;
	return true;
}
}
