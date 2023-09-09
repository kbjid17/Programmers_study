class Solution {
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < str1.length(); i++) {
            answer.append(str1.substring(i,i+1));
            answer.append(str2.substring(i,i+1));
        }
        return answer.toString();
    }
}