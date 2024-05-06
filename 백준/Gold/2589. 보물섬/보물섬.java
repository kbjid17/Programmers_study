import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] ar;
	static boolean[][] visited;
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static ArrayList<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		// 육지로만 이동 가능
		// 한 칸 이동 시 한시간 소요
		// 서로 간에 최단 거리로 이동하는 데 있어 가장 긴 시간이 걸리는 육지 두 곳에 묻혀 있음
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		ar = new char[R][C];
		for (int i = 0; i < R; i++) {
			ar[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(ar[i][j] == 'L')
					list.add(new int[] {i,j});
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			visited = new boolean[R][C];
			visited[list.get(i)[0]][list.get(i)[1]] = true;
			bfs(list.get(i)[0], list.get(i)[1]);
		}

		System.out.println(ans);
	}

	static void bfs(int i,int j) {

		q.offer(new int[] {i,j,0}); //y좌표, x좌표, 깊이
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = n[0] + dy[d];
				int nx = n[1] + dx[d];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || ar[ny][nx] == 'W') continue;
				
				ans = ans < n[2]+1 ? n[2]+1 : ans;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx,n[2] +1});
			}
		}
	}
}