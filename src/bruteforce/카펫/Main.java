package bruteforce.카펫;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int brown,yellow;
	static int[] answer;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		brown = Integer.parseInt(st.nextToken());
		yellow = Integer.parseInt(st.nextToken());
		int a = brown + yellow;
		
		for (int i = 1; i <= a; i++) {
			if(a % i == 0 && a/i >= i) {
				list.add(new int[] {a/i,i});
			}
		}
		System.out.println(list.get(list.size()-1)[0] + " " + list.get(list.size()-1)[1]);
	}

}
