package sort.k번째수;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < commands.length; i++) {
            int[] ar = new int[array[commands[i][1]]-array[commands[i][0]]+1];
            for (int j = 0; j < ar.length; j++) {
				ar[j] = array[commands[i][0]-1+j];
			}
            Arrays.sort(ar);
            answer.add(ar[commands[i][2]-1]);
        }
        int[] answers = new int[answer.size()+1];
        for (int i = 0; i < answer.size(); i++) {
			answers[i] = answer.get(i);
		}
        return answers;
    }
}