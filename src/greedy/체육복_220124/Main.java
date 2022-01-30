package greedy.체육복_220124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,l,r;
	static long ans;
	static int[] lost,reserve;
	static boolean[][] numb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		lost = new int[l]; // 체육복을 잃어버린 학생 번호
		reserve = new int[r]; // 체육복을 돌려주러 온 학생 번호
		// 체육복을 빌려주러 온 학생은 본인 번호의 앞/뒷번호의 학생한테만 옷을 빌려줄 수 있음
		// ex) 3번 학생은 2번 혹은 4번 학생에게 옷을 빌려줄 수 있음
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < l; i++) {
			lost[i] = Integer.parseInt(st.nextToken());
			
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			reserve[i] = Integer.parseInt(st.nextToken());
		}
		//여기서부턴 Solution으로 가져가도 됨
		Arrays.sort(reserve);
		numb = new boolean[n+1][2];
		for (int i = 0; i < l; i++) {
			numb[lost[i]][0] = true; // numb가 true 인 학생 : 체육복 분실
			numb[lost[i]][1] = true; // 만약 빌려주려 왔는데 잃어버린 학생일 경우
		}
		//체육복을 돌려줄 때, 자기보다 낮은 수를 가지고 있는 학생에게 우선적으로 옷을 빌려줌
		for (int i = 0; i < r; i++) {
			if(numb[reserve[i]][1]) { //본인이 빌려주러 왔는데 일어버린 경우
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
				if(numb[reserve[i]-1][0]) {
					numb[reserve[i]-1][0] = false;
					
					continue;
				}
				else if(numb[reserve[i]+1][0]) {
					numb[reserve[i]+1][0] = false;
					
					continue;
				}
			}
		}
		for (int i = 1; i < numb.length; i++) {
			if(!numb[i][0]) ans++;
		}
		System.out.println(ans);
	}

}
