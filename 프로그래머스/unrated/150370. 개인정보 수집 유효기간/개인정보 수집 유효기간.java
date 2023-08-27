import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer_list = new ArrayList<Integer>();
        
        int[][] ar = new int[privacies.length][3];
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int today_int = Integer.parseInt(String.join("", today.split("\\.")));
        System.out.println("오늘 : " + today_int);
        for(int i = 0; i < terms.length; i++) {
            String[] term_ar = terms[i].split(" ");
            map.put(term_ar[0], Integer.parseInt(term_ar[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            String[] ss = privacies[i].split(" ")[0].split("\\.");
            ar[i][0] = Integer.parseInt(ss[0]);
            ar[i][1] = Integer.parseInt(ss[1]);
            ar[i][2] = Integer.parseInt(ss[2])-1;
            
            ar[i][1] += map.get(s[1]);
            
            if(ar[i][2] == 0) {
                ar[i][2] = 28;
                ar[i][1] -=1;
            }
            
            if(ar[i][1] == 0) {
                ar[i][1] = 12;
                ar[i][0] -=1;
            }
            else {
                while(ar[i][1] > 12) {
                    ar[i][0]++;
                    ar[i][1] -= 12;
                }
            }
            System.out.println(ar[i][0] + "." + ar[i][1] + "." + ar[i][2]);
            String d = "";
            for(int j = 0; j < ar[i].length; j++) {
                d += ar[i][j] < 10 ? ("0" + ar[i][j]) : ar[i][j];
            }
            if(today_int > Integer.parseInt(d)) answer_list.add(i+1);
            

        }
        
        System.out.println(answer_list.toString());
        
        int[] answer = new int[answer_list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}