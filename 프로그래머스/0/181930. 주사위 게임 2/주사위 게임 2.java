import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int[] ar = {a,b,c};
        Arrays.sort(ar);
        
        if(ar[0] == ar[2]) {
            answer = (a+b+c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }
        else {
            if(ar[0] == ar[1] || ar[1] == ar[2])
                answer = (a+b+c) * (a*a + b*b + c*c);
            else
                answer = a+b+c;
        }
        return answer;
    }
}