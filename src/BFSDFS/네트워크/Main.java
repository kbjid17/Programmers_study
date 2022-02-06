package BFSDFS.네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,answer;
	static ArrayList[] lists;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[][] computers;
	static boolean[] visit;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		lists = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		computers = new int[n][n];
		check = new boolean[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				computers[i][j] = Integer.parseInt(st.nextToken());
				if(i == j) 	continue;
				if(computers[i][j] == 1)	lists[i].add(j);
				
			}
		}
		bfs();
		// 해당 네트워크가 처음 발견된 것이라면
		// bfs로 이 네트워크와 연결된 모든 네트워크를 찾아 true 처리
		// 이미 발견된 네트워크라면 생략
		// [i][j]는 연결되어 있는데 [j][i] 가 연결되어 있지 않으면 연결되어 있지 않은 것임. ==> 서로 연결되어 있어야 네트워크 성립
		
		//연결 여부를 결정한 뒤 -> bfs에서 값을 참조할 때 check[a][b] = true고 check[b][a] = true면 a와 b를 visit 처리
		
		System.out.println(answer);
	}
	// a와 b를 이어주고[a][b]
	// b와 a를 이어줌 [b][a] => 서로 이어져 있다는 걸 어떻게 증명하지 check[a][b] && check[b][a]
	static void bfs() {
		for (int i = 0; i < n; i++) {
			if(visit[i]) continue; //이미 네트워크가 구성이 완료된 상태면 생략
			//네트워크 구성 시작
			queue.offer(i);
			while(!queue.isEmpty()) {
				Integer a = queue.poll(); //해당 수를 시작으로 네트워크 구축
				visit[a] = true; // 현재 방문한상태
				for (int j = 0; j < lists[a].size(); j++) { // 해당 리스트 안에 들어 있는 컴퓨터를 탐색
					if(visit[(int) lists[a].get(j)]) continue; // 이미 네트워크 구축이 확인된 곳이면 생략
					check[i][(int) lists[a].get(j)] = true; // i와 lists[a].get(j)가 연결됨
					// 탐색 생략 조건
						/*
						 a -> b를 연결한 후 b로 이동,
						 b에서 a로 이동하려는 경로가 확인될 경우 추가 목록에서 제외 
						 */
					
					if(check[i][(int) lists[a].get(j)] && check[(int) lists[a].get(j)][i]) {	//만약 쌍으로 연결이 완료된 상태라면
						visit[(int) lists[a].get(j)] = true;
						continue;
					}
					queue.offer((int) lists[a].get(j)); //연결되지 않았던 새로운 컴퓨터일 경우, 이 컴퓨터와 연결된 요소들을 다시 탐색
				}
			}
			answer++;
		}
	}
}