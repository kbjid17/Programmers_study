class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string;
        
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(s,e+1));
        sb.reverse();
        sb.append(my_string.substring(e+1));
        sb.insert(0,my_string.substring(0,s));
        
        return sb.toString();
    }
}