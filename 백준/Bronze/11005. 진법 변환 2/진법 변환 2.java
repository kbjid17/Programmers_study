import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cc = 1124772750;
//		System.out.println(cc/15);
		int n_base = n; // 구해야 할 결괏값의 길이를 구하기 위함
		StringBuilder sb = new StringBuilder();
		double num = 1;
		int len = 0;
		while(n >= num) {
			num *= b;
			len++;
		}
		while(n > 0) {
//			System.out.println(num+"에서");
			num /= b;
			if(num == 0) num = 1;
			double div = num; // 해당 수로 나눠야 함
//			System.out.println(div);
			
			if(n < div) {
				sb.append(0);
//				System.out.println( "0 넣기");
				continue;
			}
			
			int add_num = n/(int)div; 
			if(add_num >= 10) sb.append((char)(add_num+55));
			else sb.append(add_num);
			
			n %= div;
		}
		while(sb.length() < len) sb.append("0");
		System.out.println(sb);
	}

}
