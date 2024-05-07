import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] ar = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < ar.length; i++) {
			long sum = 0;
			for (int j = i; j < ar.length; j++) {
				sum += ar[j];
				
				if(sum >= M) {
					if(sum == M) {
						ans++;
					}
					break;
				}
			}
			
		}
		System.out.println(ans);
	}

}