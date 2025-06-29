import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] ch = my_string.toCharArray();
        
        for(int i = 0; i < queries.length; i++) {
            char[] ch_2 = new char[queries[i][1] - queries[i][0]+1];
            
            for(int j = 0; j < ch_2.length; j++) {
                ch_2[j] = ch[queries[i][1] - j];
                
            }
            
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                ch[j] = ch_2[j - queries[i][0]];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : ch) sb.append(c);
        
        return sb.toString();
    }
}