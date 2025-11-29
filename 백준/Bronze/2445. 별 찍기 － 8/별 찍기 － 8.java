import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= (2*n-1); i++) {
			if(i <= n) {
				for (int j = 1; j <= 2*n; j++) {
					if(j <= i || j > (2*n-i))
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			else {
				for (int j = 1; j <= 2*n; j++) {
					if(j <= (2*n-i) || j > i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}