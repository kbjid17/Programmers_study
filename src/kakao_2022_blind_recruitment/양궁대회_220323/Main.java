package kakao_2022_blind_recruitment.양궁대회_220323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, sa,sl,ans;
	static int[] info = new int[11]; // 어파치가 맞춘 화살 개수
	static int[] lion = new int[11];
	static int[] answer = new int[11]; // 라이언이 맞힌 화살 개수(답)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= 10; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		if(ans == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
			System.out.println(Arrays.toString(answer)); 
			
		}
		
	}
	//점수를 넣는 중복조합을 구해야 함.
	
	
	static void comb(int srcIdx,int point) {
		if(point == n) { //n개 만큼의 화살을 다 쐈다면
			sa = 0;
			sl = 0;
			for (int i = 0; i < 11; i++) {
				if(info[i] == lion[i] && info[i] > 0) {
					sa += (10-i);
				}
				else if(info[i] > lion[i]) {
					sa += (10-i);
				}
				else if(info[i] < lion[i]) {
					sl += (10-i);
				}
			}
			if(sa < sl) {
				if(ans < sl-sa) {
					ans = Math.max(ans, sl-sa);
					for (int i = 0; i < answer.length; i++) {
						answer[i] = lion[i];
					}
				}
			}
			return;
		}
		
		lion[srcIdx] += 1;
		comb(srcIdx,point+1); // 점수 넣고 같은 과녁에서 진행
		lion[srcIdx] -= 1;
		if(srcIdx < 10) {
			comb(srcIdx+1,point); // 점수 안넣고 다음 과녁으로 이동
		}
 	}
}