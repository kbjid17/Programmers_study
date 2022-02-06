package DP.N으로표현_220202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,number,answer = 1;
	static ArrayList<Integer>[] str = new ArrayList[9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		number = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 8; i++) {
			str[i] = new ArrayList<Integer>();
		}
		while(true) {
			if(answer == 9) {
				answer = -1;
				break;
			}
			else if(answer == 1) {
				str[answer].add(N);
			}
			else {
				for (int i = 0; i < str[answer].size(); i++) {
					for (int j = 0; j < str[answer-1].size(); j++) {
						str[answer].add(str[answer-1].get(i)+str[answer].get(j));
						str[answer].add(str[answer-1].get(i)-str[answer].get(j));
						str[answer].add(str[answer-1].get(i)*str[answer].get(j));
						if(str[answer].get(j) != 0)
							str[answer].add(str[answer-1].get(i)/str[answer].get(j));
					}
				}
			}
			for (int i = 0; i < args.length; i++) {
				
			} 
			answer++;
		}
		
		System.out.println(answer);
	}

}
