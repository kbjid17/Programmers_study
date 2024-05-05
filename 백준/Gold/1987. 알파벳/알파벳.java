import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C; // 세로 R칸, 가로 C칸
	static int ans = Integer.MIN_VALUE;
	static char[][] ar;
	static int[] dy = {1,-1,0,0};
	static HashSet<Character> h = new HashSet<Character>();
	static int[] dx	= {0,0,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ar = new char[R][C];
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = br.readLine().toCharArray();
		}

		h.add(ar[0][0]);
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int y, int x) { // 가지치기가 필요하다
		// 조회한 알파벳의 갯수를 구한다
		ans = ans < h.size() ? h.size() : ans;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
			
			if(!h.contains(ar[ny][nx])) {
				  h.add(ar[ny][nx]);
				  dfs(ny,nx);
				  
				  h.remove(ar[ny][nx]);
			}
			
		}
		
		
	}


}
