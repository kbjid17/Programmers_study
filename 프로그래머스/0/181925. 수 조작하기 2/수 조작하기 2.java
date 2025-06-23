class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        int n = numLog[0];
        for(int i = 1; i < numLog.length; i++) {
            if(numLog[i] == n+1) {
                sb.append("w");
            }
            else if(numLog[i] == n-1) {
                sb.append("s");
            }
            else if(numLog[i] == n+10) {
                sb.append("d");
            }
            else if(numLog[i] == n-10) {
                sb.append("a");
            }
            n = numLog[i];
        }
        return sb.toString();
    }
}