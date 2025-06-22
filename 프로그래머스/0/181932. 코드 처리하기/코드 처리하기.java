class Solution {
    public String solution(String code) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int mode = 0;
        char[] ar = code.toCharArray();
        for(int i = 0; i < ar.length; i++) {
            char c = ar[i];
            
            if(c == '1') {
                mode ^= 1;
                continue;
            }
            if(mode == 0 && i % 2 == 0) sb.append(c);
            else if(mode == 1 && i % 2 != 0) sb.append(c);
        }
        if(sb.toString().equals("")) answer = "EMPTY";
        else answer = sb.toString();
        return answer;
    }
}