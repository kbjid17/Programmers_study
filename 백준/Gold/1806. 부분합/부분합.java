import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> d = new ArrayDeque<Integer>();

	static long sum = 0;
	static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		
		int ans = Integer.MAX_VALUE;
		int[] ar = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < ar.length; i++) {
			d.offerLast(ar[i]);
			sum += ar[i];
			size++;
			// size : 1
			if(ar[i] >= S) {
				ans = 1;
				break;
			}
			
			if(sum >= S) {
//				System.out.println(ar[i] + "에서");
				ans = Math.min(d.size(), ans);
				while(sum >= S) {
					int a = d.pollFirst();
//					System.out.println(a);
					sum -= a;
					size--;
					if(sum >= S)
						ans = Math.min(ans, size);
				}
			}
			
			
		}
		if(ans == Integer.MAX_VALUE)
			System.out.println(0);
		else 
			System.out.println(ans);
	}

}