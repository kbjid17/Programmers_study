class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++) {
            String[] ar = quiz[i].split(" ");
            int val = 0;
            if(ar[1].equals("-")) {
                 val = Integer.parseInt(ar[0]) - Integer.parseInt(ar[2]);
            }
            else if(ar[1].equals("+")) {
                 val = Integer.parseInt(ar[0]) + Integer.parseInt(ar[2]);
            }
            
            answer[i] = val == Integer.parseInt(ar[4]) ? "O" : "X";
        }
        return answer;
    }
}