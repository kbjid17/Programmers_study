package 그래프.순위_220223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,game; // 선수 수, 경기 횟수
	static boolean[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		game = Integer.parseInt(br.readLine());
		ar = new boolean[n+1][n+1];
		for (int i = 0; i < game; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			ar[w][l] = true; // w번 선수가 l번 선수를 이김
		}
		// 모든 플레이어와 연결되어 있다? 그럼 해결 가능!
	}

}


/*
1번 : 2번한테 이김
2번 : 5번한테 이기고, 1,3,4번한테 짐
3번 : 2번한테 이기고, 4번한테 짐
4번 : 2,3번한테 이김
5번 : 2번한테 짐
*/