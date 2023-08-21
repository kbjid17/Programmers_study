import java.lang.Math;

class Solution {
    public int solution(int[][] sizes) {
        int maxa = 0;
        int maxb = 0;
        for(int i = 0; i < sizes.length; i++) {
            maxa = Math.max(maxa,Math.max(sizes[i][0], sizes[i][1]));
            maxb = Math.max(maxb,Math.min(sizes[i][0], sizes[i][1]));
        }
        return maxa * maxb;
    }
}