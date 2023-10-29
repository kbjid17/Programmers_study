import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static double N; 
	static int ex;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Double.parseDouble(br.readLine());
		ex = (int) Math.round(N*0.15);
		
//		System.out.println(N + " " + ex) ;
		
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int size = pq.size();
		int div = (int) (N - ex*2);
		double ans = 0;
		
//		System.out.println("size : "+ pq.size());
		for (int i = 0; i < size; i++) {
			int n = pq.poll();
			if(i < ex || i >= N - ex) continue;
//			System.out.println(n);
			ans+= n;
		}
		System.out.println((int) Math.round(ans/div));

	}

}
