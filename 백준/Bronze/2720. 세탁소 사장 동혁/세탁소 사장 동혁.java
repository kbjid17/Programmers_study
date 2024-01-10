import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			int money = Integer.parseInt(br.readLine());
			
			// 쿼터 (0.25) > 다임(0.10) > 니켈(0.05) > 페니(0.01)
			int q = money/25;
			sb.append(q).append(" ");
			money %= 25;
			
			int d = money/10;
			sb.append(d).append(" ");
			money %= 10;
			
			int n = money/5;
			sb.append(n).append(" ");
			money %= 5;
			
			sb.append(money);
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}