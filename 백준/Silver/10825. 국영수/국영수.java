import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<student> pq = new PriorityQueue<student>();
		int n = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			student stud = pq.poll();
//			System.out.println(stud.name + " " + stud.ln + " " + stud.en + " " + stud.mt);
			sb.append(stud.name).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class student implements Comparable<student>{
		String name; // 학생 이름
		int ln; // 국어 성적
		int en; // 영어 성적
		int mt; // 수학 성적
		public student(String name, int ln, int en, int mt) {
			super();
			this.name = name;
			this.ln = ln;
			this.en = en;
			this.mt = mt;
		}
		@Override
		public int compareTo(student o) {
			// 리턴값이 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우엔 두 객체의 자리가 바뀜
			int ls_comp = this.ln - o.ln;
			int en_comp = this.en - o.en;
			int mt_comp = this.mt - o.mt;
//			System.out.println(this.ln + " " + o.ln + " " + ls_comp);
			
			// 1. 국어 점수가 감소하는 순서대로
			if(ls_comp > 0 ) return -1;
			else if(ls_comp == 0){
				// 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
				if(en_comp < 0) return -1;
				else if(en_comp == 0) {
					// 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
					if(mt_comp > 0) return -1;
					else if(mt_comp == 0) {
						// 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로(단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
						if(this.name.compareTo(o.name) > 0) return 1; // 사전순으로 뒤에 있으면 양수 반환, 앞에 있으면 음수 반환, 동일하면 0 반환
						else return -1;
					}
					else return 1;
				}
				else return 1;
			}
			else return 1;
			
			
		}
	}
}