import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = l; i <= r; i++) {
            boolean five = true;
            char[] ch = Integer.toString(i).toCharArray();
            for(char c : ch) {
                if(c != '0' && c != '5') {
                    five = false;
                    break;
                }
            }
            if(five)
                list.add(i);
        }
        int[] answer;
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}