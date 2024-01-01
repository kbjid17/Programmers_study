import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	
	static Stack<Double> stack_num = new Stack<Double>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] ar = br.readLine().toCharArray();
		double[] nums = new double[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}
		for (int i = 0; i < ar.length; i++) {
//			System.out.println(ar[i]);
			if((ar[i] >= 'A' && ar[i] <= 'Z')) {
				stack_num.push(nums[ar[i]-'A']);
			}
			else {
				double a = stack_num.pop();
				double b = stack_num.pop();
				double res = 0.00;
				switch(ar[i]) {
					case '+':
						res = b+a;
						break;
					case '-':
						res = b-a;
						break;
					case '*':
						res = b*a;
						break;
					case '/':
						res = b/a;
						break;
				}
				stack_num.push(res);
			}
		}
		
//		double ans = Math.floor(stack_num.pop()*100)/100;
//		System.out.println(ans);
		System.out.printf("%.2f", stack_num.pop());
	}

}