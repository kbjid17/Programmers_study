class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < answer.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                if(arr[j] > queries[i][2]) min = Math.min(min, arr[j]);
            }
            if(min == Integer.MAX_VALUE) min = -1;
            answer[i] = min;
            
        }
        return answer;
    }
}