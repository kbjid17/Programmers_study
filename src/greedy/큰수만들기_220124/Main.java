package greedy.큰수만들기_220124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String number;
	static String[] ar;
	static int k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = br.readLine();
		k = Integer.parseInt(br.readLine());
		
		ar = number.split("");
		int[] numbar = new int[ar.length];
		for (int i = 0; i < numbar.length; i++) {
			numbar[i] = Integer.parseInt(ar[i]);
		}
		
		
		// 주어진 수들 중 k개를 빼는 알고리즘
	}
}
