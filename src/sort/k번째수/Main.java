package sort.k번째수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] array,ar,answers;
	static int[][] commands;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		commands = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				commands[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < commands.length; i++) {
            int[] ar = new int[commands[i][1]-commands[i][0]+1];
            for (int j = 0; j < ar.length; j++) {
				ar[j] = array[commands[i][0]-1+j];
			}
            Arrays.sort(ar);
            answer.add(ar[commands[i][2]-1]);
        }
        int[] answers = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
			answers[i] = answer.get(i);
		}
        	System.out.println(Arrays.toString(answers));
	}

}
