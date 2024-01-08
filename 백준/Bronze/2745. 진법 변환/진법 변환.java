import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] n = st.nextToken().toCharArray();
		
		int b = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 0; i < n.length; i++) {
			int num = 0;
			if(n[i] >= '0' && n[i] <= '9')	     num = (int) ((n[i]-'0') * Math.pow(b, n.length-1-i));
			
			else if (n[i] >= 'A' && n[i] <= 'Z') num = (int) ((n[i]-'A' + 10) * Math.pow(b,n.length-1-i));
			
			ans += num;
		}
		
		System.out.println(ans);
	}

}