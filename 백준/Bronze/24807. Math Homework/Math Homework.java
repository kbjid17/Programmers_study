import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int i = 0; a*i <= n; i++) {
			for (int j = 0; ((a*i) + (b*j)) <= n; j++) {
				for (int k = 0; ((a*i) + (b*j) + (c*k)) <= n; k++) {
					if(((a*i) + (b*j) + (c*k)) == n) {
						ans++;
						System.out.println(i + " " + j + " " + k);
					}
				}
			}
		}
		
		if(ans == 0) {
			System.out.println("impossible");
		}
	}
}