import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        
        for(int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) >= 48 && my_string.charAt(i) <= 58)
                list.add(my_string.charAt(i)-48);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}