import java.util.ArrayList;

class Solution {
	static ArrayList<int[]> list = new ArrayList<int[]>();
    public int[] solution(int brown, int yellow) {
        int div = 0;
        int[] answer = new int[2];
        while(div < yellow) {
            div++;
            if(yellow % div != 0) continue;
            int ex = (yellow/div)+2;
            int ey = div+2;
            if(brown == ex*ey-yellow) {
                answer = new int[]{ex,ey};
                break;
            }
        }
        return answer;
    }
}