import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < T; i++) {
				String n = br.readLine().trim();
				
				String regex = "^[0-9]+$";
				
				if(!n.matches(regex)) {
					System.out.println("invalid input");
				}
				else {
					BigInteger num = new BigInteger(n);					
					System.out.println(num);
				}
			}
	}
}