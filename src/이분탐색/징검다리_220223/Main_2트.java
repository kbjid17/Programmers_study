package 이분탐색.징검다리_220223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2트 {
	static int distance,n,rockq;
	static long answer;
	static long[] rocks; // 돌의 위치가 적힌 배열, tgt : 다리에서 제외될 돌의 위치가 기록될 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		distance = Integer.parseInt(br.readLine());
		rockq = Integer.parseInt(br.readLine());
		rocks = new long[rockq]; // 0 : 시작 위치, 1~rockq : 돌의 위치 , rockq : 최종 도착 위치
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < rocks.length; i++) {
			rocks[i] = Long.parseLong(st.nextToken());
		}
		n = Integer.parseInt(br.readLine());
		Arrays.sort(rocks);
		long left = 0;
		long right = distance;
		long mid = 0;
		
		while(left <= right) {
			mid = (left+right)/2;
			long prevpos = 0;
			int removeCnt = 0;
			for (int i = 0; i < rocks.length; i++) {
				if(Math.abs(prevpos-rocks[i]) < mid) {
					removeCnt++;
					if(removeCnt > n) break;
				}
				else {
					prevpos = rocks[i];
				}
			}
			if(removeCnt > n) {
				right = mid-1;
			}
			else {
				answer = answer > mid ? answer : mid;
				left = mid+1;
			}
		}
		System.out.println(answer);
	}
}