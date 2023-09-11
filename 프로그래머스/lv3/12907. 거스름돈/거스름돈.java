import java.util.*;

class Solution {
    public long solution(int n, int[] money) {
        Arrays.sort(money);
        long[][] ar = new long[money.length][n+1];
        
        for(int i = 0; i < money.length; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0) {
                    if(j % money[i] == 0) ar[i][j] = 1;
                }
                else {
                    if(j < money[i]) ar[i][j] = ar[i-1][j]; 
                    else {
                        ar[i][j] = 
                            ar[i][j] + ar[i-1][j] 
                                            + ar[i][j-money[i]];
                    }
                }
            }
        }
        
        // for(int i = 0; i < ar.length; i++) {
        //     for(int j = 0; j < ar[0].length; j++) {
        //         System.out.print(ar[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
       
        return ar[ar.length-1][n] % 1000000007;
    }
}