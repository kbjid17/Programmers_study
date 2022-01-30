package greedy.조이스틱_220124;

class Solution {
    public int solution(String name) {
    	int acount = 0;
    	int pos = 0;
        int answer = 0;
        char[] ar = name.toCharArray();
        for (int i = 0; i < ar.length; i++) {
			if(ar[i] == 'A') {
				acount++;
				continue;
			}
			//1. 알파벳 구축에 걸린 과정
			if((int) ar[i] > 64 && (int) ar[i] <= 77) { 
				answer+= (int)ar[i] -64;
			}
			else if((int)ar[i] > 77) {
				answer+= 90-(int)ar[i];
			}
		}
		if(acount < ar.length) { // A말고 다른 녀석이 있을 경우(모두 A면 더할 필요가 없음)
			//2. 위치 정보를 계산
			for (int i = 0; i < ar.length; i++) { // 문자의 위치를 하나하나 보면서 A가 아닌 문자의 위치를 찾아 앞쪽에 있는지 뒷쪽에 있는지 확인
				if(ar[i] != 'A') {
					// 현재 입력의 위치를 기준으로 이동 횟수가 더 적은 방향으로 이동 진행(오른쪽으로 이동하는게 적은지 왼쪽으로 이동하는게 적은지
					int pos_r = pos; // 오른쪽으로 이동할 좌표(다음 알파벳을 보러 가는거)
					int pos_rcnt = 0; // 오른쪽으로 이동한 카운트
					int pos_l = pos; // 왼쪽으로 이동할 좌표(이전 알파벳을 보러 가는거)
					int pos_lcnt = 0; // 왼쪽으로 이동한 카운트
					// 1) 오른쪽으로 이동하는 경우
					while(pos_r != i) {
						pos_r += 1;
						if(pos_r == ar.length) pos_r = 0;
						pos_rcnt += 1;
					}
					// 2) 왼쪽으로 이동하는 경우
					while(pos_l != i) {
						pos_l -= 1;
						if(pos_l == -1) pos_l = ar.length-1;
						pos_lcnt += 1;
					}
					pos = pos_rcnt <= pos_lcnt ? pos_r : pos_l; // 적게 이동한 위치로 이동(이건 pos_r이나 pos_l이나 상관없음)
					answer += pos_rcnt <= pos_lcnt ? pos_rcnt : pos_lcnt; // 적게 이동하는 방향으로 이동한 카운트를 더함.
				}
			}
		}
        return answer;
    }
}