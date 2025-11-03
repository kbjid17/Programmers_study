import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int[] ar = new int[9];
		 for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		 Arrays.sort(ar);
		 for (int i = 0; i < ar.length-1; i++) {
			for (int j = i+1; j < ar.length; j++) {
				int num = 0;
				for (int k = 0; k < ar.length; k++) {
					if(k == i || k == j) continue;
					num += ar[k];
				}
				
				if(num == 100) {
					for (int k = 0; k < ar.length; k++) {
						if(k == i || k == j) continue;
						System.out.println(ar[k]);
					}
					return;
				}
			}
		}

	}

}
