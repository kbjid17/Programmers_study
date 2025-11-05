import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int nn = 1;
		for (int i = n; i > 0; i--) {
			for (int j = i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < nn; j++) {
				System.out.print("*");
			}
			nn += 2;
			System.out.println();
		}

	}

}