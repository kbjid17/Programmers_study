import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == -1) {
				break;
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			int sqrt = (int) Math.sqrt(num);
			
			for (int i = 1; i <= sqrt; i++) {
				if(num % i == 0) {
					list.add(i);
					
					if(num / i != i && num/i != num) {
						list.add(num/i);
					}
				}
			}
			Collections.sort(list);
			
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			String sumstr = "";
			
			if(num == sum) {
				sumstr = num + " = ";
				for (int i = 0; i < list.size(); i++) {
					sumstr += list.get(i);
					if(i != list.size()-1) {
						sumstr += " + ";
					}
				}
			}
			else {
				sumstr = num + " is NOT perfect.";
			}
			
			System.out.println(sumstr);
		}
	}

}
