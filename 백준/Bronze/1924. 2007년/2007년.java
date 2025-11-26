import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		LocalDate localDate = LocalDate.of(2007, month, day);
		
		int dayOfWeek = localDate.getDayOfWeek().getValue();

		switch(dayOfWeek) {
		case 1 : 
			System.out.println("MON");
			break;
		case 2 : 
			System.out.println("TUE");
			break;
		case 3 : 
			System.out.println("WED");
			break;
		case 4 : 
			System.out.println("THU");
			break;
		case 5 : 
			System.out.println("FRI");
			break;
		case 6 : 
			System.out.println("SAT");
			break;
		case 7 : 
			System.out.println("SUN");
			break;
		}
	}

}
