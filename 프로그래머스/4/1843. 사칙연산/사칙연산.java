class Solution {
    public int solution(String arr[]) {
        int answer = Integer.MIN_VALUE;
        int num = arr.length/2+1; // arr 내의 숫자 개수
        int[] dp = new int[num];
        int[][] max_dp = new int[num][num];
        int[][] min_dp = new int[num][num];
        
        for(int i = 0; i < num; i++) {
            if(i == 0) dp[i] = Integer.parseInt(arr[i]);
            else dp[i] = Integer.parseInt(arr[i*2]);
            
            for(int j = 0; j < num; j++)
                if(i == j) {
                    max_dp[i][j] = dp[i];
                    min_dp[i][j] = dp[i];
                }
                else {
                    max_dp[i][j] = Integer.MIN_VALUE;
                    min_dp[i][j] = Integer.MAX_VALUE;
                }
            
        }
        
        for(int i = 1; i < num; i++) {
            for(int j = 0; j < num-i; j++) {
                int k = i+j;
                for(int l = j; l < k; l++) {
                    if(arr[l*2+1].equals("+")) {
                        max_dp[j][k] = Math.max(max_dp[j][k], max_dp[j][l] + max_dp[l+1][k]);
                        min_dp[j][k] = Math.min(min_dp[j][k], min_dp[j][l] + min_dp[l+1][k]);
                    }
                    else if(arr[l*2+1].equals("-")) {
                        max_dp[j][k] = Math.max(max_dp[j][k], max_dp[j][l] - min_dp[l+1][k]);
                        min_dp[j][k] = Math.min(min_dp[j][k], min_dp[j][l] - max_dp[l+1][k]);
                    }
                }
            }
        }
        
        answer = max_dp[0][num-1];
        
        return answer;
    }
}