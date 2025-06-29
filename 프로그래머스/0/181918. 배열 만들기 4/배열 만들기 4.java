import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        
        int idx = 0;
        while(idx < arr.length) {
            int num = arr[idx];
            
            if(ar.size() == 0) {
                ar.add(num);
                idx++;
            }
            else {
                if(ar.get(ar.size()-1) < num) {
                    ar.add(num);
                    idx++;
                }
                else {
                    ar.remove(ar.size()-1);
                }
            }
        }
        int[] stk = new int[ar.size()];
        for(int i = 0; i < stk.length; i++) {
                stk[i] = ar.get(i);
            }
        return stk;
    }
}