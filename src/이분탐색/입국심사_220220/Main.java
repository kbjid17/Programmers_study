package 이분탐색.입국심사_220220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long n;
	static long[] times;
	static long answer; // 시간의 최솟값
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int timel = Integer.parseInt(br.readLine());
		times = new long[timel];
		long start = 0;
		long end = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < times.length; i++) {
			times[i] = Integer.parseInt(st.nextToken());
			start += times[i];
			end = Math.max(end, times[i]);
		}
		end *= n; // end : 최대로 걸리는 값
		Arrays.sort(times);
		//start : 최초로 부여되는 시간
		while(start <= end) {
			int sum = 0;
			long mid = (start + end)/2;
			for (int i = 0; i < times.length; i++) {
				sum += mid/times[i];
			}
			if(sum < n) {
				start = mid+1;
			}else {
				end = mid-1;
				answer = mid;
			}
			
		}
		System.out.println(answer);
	}

}
