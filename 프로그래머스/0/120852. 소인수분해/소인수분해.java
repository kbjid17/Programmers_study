import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                while(n % i == 0)
                    n /= i;
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}