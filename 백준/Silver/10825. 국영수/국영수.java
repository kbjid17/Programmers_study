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
			sb.append(stud.name).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class student implements Comparable<student>{
		String name; 
		int ln; 
		int en; 
		int mt; 
		public student(String name, int ln, int en, int mt) {
			super();
			this.name = name;
			this.ln = ln;
			this.en = en;
			this.mt = mt;
		}
		@Override
		public int compareTo(student o) {
			int ls_comp = this.ln - o.ln;
			int en_comp = this.en - o.en;
			int mt_comp = this.mt - o.mt;

			if(ls_comp > 0 ) return -1;
			else if(ls_comp == 0){
				if(en_comp < 0) return -1;
				else if(en_comp == 0) {
					if(mt_comp > 0) return -1;
					else if(mt_comp == 0) {
						if(this.name.compareTo(o.name) > 0) return 1; 
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
