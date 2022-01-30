package greedy.구명보트_220130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] people;
	static int limit,n,p,ans; //ps : people 크기
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p = Integer.parseInt(br.readLine());
		people = new int[p];
		limit = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(people);
		
			int start = 0;
			int end = people.length-1;
			while(end >= start) {
				int weight = people[end--];
				if(weight + people[start] <= limit) {
					start++;
				}
				ans++;
			}
		
		System.out.println(ans);
	}

}
