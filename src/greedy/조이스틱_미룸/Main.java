package greedy.조이스틱_미룸;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] name;
	static int ans,acount,pos;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine().toCharArray();
//		System.out.println((int)'A' + " " + (int)'Z');
//		for (int i = 0; i < name.length; i++) {
//			if((int)name[i] >= 65 && (int)name[i] <= 90) {
//				System.out.println(123);
//			}
//		}
		//1. 알파벳 위치를 갱신
		/*
		 * 중간 값 : 64 + 90 = 154/2 = 77(M)을 기준으로 생각할것
		 * M이거나 M보다 작을 경우 : n-64
		 * M보다 클 경우 : 90-n
		 */
		for (int i = 0; i < name.length; i++) {
			if(name[i] == 'A') {
				acount++;
				continue;
			}
			if((int) name[i] > 64 && (int) name[i] <= 77) {
				ans+= (int)name[i] -64;
			}
			else if((int)name[i] > 77) {
				ans+= 90-(int)name[i];
			}
		}
		if(acount < name.length) { // A말고 다른 녀석이 있을 경우(모두 A면 더할 필요가 없음)
			//2. 위치 정보를 계산
			for (int i = 0; i < name.length; i++) { // 문자의 위치를 하나하나 보면서 A가 아닌 문자의 위치를 찾아 앞쪽에 있는지 뒷쪽에 있는지 확인
				if(name[i] != 'A') {
					// 현재 입력의 위치를 기준으로 이동 횟수가 더 적은 방향으로 이동 진행(오른쪽으로 이동하는게 적은지 왼쪽으로 이동하는게 적은지
					int pos_r = pos; // 오른쪽으로 이동할 좌표
					int pos_rcnt = 0; // 오른쪽으로 이동한 카운트
					int pos_l = pos; // 왼쪽으로 이동할 좌표
					int pos_lcnt = 0; // 왼쪽으로 이동한 카운트
					// 1) 오른쪽으로 이동하는 경우
					while(pos_r != i) {
						pos_r += 1;
						if(pos_r == name.length) pos_r = 0;
						pos_rcnt += 1;
					}
					// 2) 왼쪽으로 이동하는 경우
					while(pos_l != i) {
						pos_l -= 1;
						if(pos_l == -1) pos_l = name.length-1;
						pos_lcnt += 1;
					}
					pos = pos_rcnt <= pos_lcnt ? pos_r : pos_l; // 적게 이동한 위치로 이동(이건 pos_r이나 pos_l이나 상관없음)
					ans += pos_rcnt <= pos_lcnt ? pos_rcnt : pos_lcnt; // 적게 이동하는 방향으로 이동한 카운트를 더함.
				}
			}
		}
		System.out.println(ans);
	}

}
