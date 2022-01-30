package greedy.체육복_220124;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(reserve);
        
        boolean[][] numb = new boolean[n+1][2];
		for (int i = 0; i < lost.length; i++) {
			numb[lost[i]][0] = true; // numb가 true 인 학생 : 체육복 분실
			numb[lost[i]][1] = true; // numb가 true 인 학생 : 체육복 분실
		}
		// 체육복을 잃어버린 학생은 체육복을 빌려주는 것도 하면 안됨
		for (int i = 0; i < reserve.length; i++) {
			if(numb[reserve[i]][1]) {
				numb[reserve[i]][0] = false;
				continue;
			}
			if(reserve[i] == 1) {
				if(numb[2][0]) {
					numb[2][0] = false;
				}
			}
			else if(reserve[i] == n) {
				if(numb[n-1][0]) {
					numb[n-1][0] = false;
				}
			}
			else {
				if(numb[reserve[i]+1][0] && numb[reserve[i]-1][0]) {
					numb[reserve[i]-1][0] = false;
				}
				else if(numb[reserve[i]-1][0] && !numb[reserve[i]+1][0]) {
					numb[reserve[i]-1][0] = false;
				}
				else if(numb[reserve[i]+1][0] && !numb[reserve[i]-1][0])
				{
					numb[reserve[i]+1][0] = false;
				}
			}
		}
		
		for (int i = 1; i < numb.length; i++) {
			if(!numb[i][0]) answer++;
		}
        return answer;
    }
}