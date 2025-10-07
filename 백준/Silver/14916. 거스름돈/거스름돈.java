import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] ar = new long[100001];
		
		ar[0] = 0;
		ar[1] = -1;
		ar[2] = 1;
		ar[3] = -1;
		ar[4] = 2;
		ar[5] = 1;
		ar[6] = 3;
		ar[7] = 2;
		ar[8] = 4;
		ar[9] = 3;
		ar[10] = 2;
		
		for (int i = 11; i <= 100000; i++) {
			if(i % 2 == 0) {
				ar[i] = ar[(i/10)*10] + ar[i%10];
				if(i % 10 == 0) ar[i] = i/5;
			}
			else {
				if(i % 5 == 0) ar[i] = i/5;
				else {
					if(i % 10 < 5) {
						ar[i] = ar[(i/5-1)*5] + ar[i-((i/5-1)*5)];
					}
					else {
						ar[i] = ar[i/5*5] + ar[i-(i/5*5)];
					}
				}
			}
			
		}
		
		System.out.println(ar[Integer.parseInt(br.readLine())]);

	}
}