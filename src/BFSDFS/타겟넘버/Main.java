package BFSDFS.타겟넘버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,target,answer;
	static int[] numbers;
	static String[] cal = {"+","-"},tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		tgt = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		target = Integer.parseInt(br.readLine());
		perm(0);
		System.out.println(answer);
		
		
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == N) {
			int num = 0;
//			System.out.println(Arrays.toString(tgt));
			for (int i = 0; i < N; i++) {
				if(tgt[i].equals("-")) num -= numbers[i];
				else if(tgt[i].equals("+")) num+= numbers[i];
			}
			if(num == target) answer++;
			return;
		}
		
		for (int i = 0; i < cal.length; i++) {
			tgt[tgtIdx] = cal[i];
			perm(tgtIdx+1);
		}
	}
}
