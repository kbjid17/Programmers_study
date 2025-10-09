import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        HashSet<Integer> h = new HashSet<Integer>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] a = operations[i].split(" ");
            if(a[0].equals("I")) {
                pq1.offer(Integer.parseInt(a[1]));
                pq2.offer(Integer.parseInt(a[1]));
                h.add(Integer.parseInt(a[1]));
            }
            else {
                if(h.size() > 0) {
                    if(Integer.parseInt(a[1]) == -1) {
                        int n = pq1.poll();
                        h.remove(n);
                    }
                    else if(Integer.parseInt(a[1]) == 1) {
                        int n = pq2.poll();
                        h.remove(n);
                    }
                    if(h.size() == 0) {
                        pq1.clear();
                        pq2.clear();
                    }
                }
            }
        }
        
        if(h.size() > 0) {
            int n1 = pq1.poll();
            int n2 = pq2.poll();
            
            answer[0] = h.contains(n2) ? n2 : n1;
            answer[1] = h.contains(n1) ? n1 : n2;
        }
        else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}