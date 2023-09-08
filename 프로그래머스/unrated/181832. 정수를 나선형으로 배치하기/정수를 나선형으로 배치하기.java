class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int dist = 2;
        int y = 0;
        int x = -1;
        for(int i = 1; i <= n*n; i++ ) {
            if(dist == 0 && (y + 1 == answer.length || answer[y+1][x] != 0)) dist = 3;
            else if(dist == 1 && (y-1 == -1 || answer[y-1][x] != 0)) dist = 2;
            else if(dist == 2 && (x+1 == answer[0].length || answer[y][x+1] != 0)) dist = 0;
            else if(dist == 3 && (x-1 == -1 || answer[y][x-1] != 0)) dist =  1;
            switch(dist) {
                case 0:
                    y++;
                    break;
                case 1:
                    y--;
                    break;
                case 2:
                    x++;
                    break;
                case 3:
                    x--;
                    break;
            }
            answer[y][x] =i;
        }
        return answer;
    }
}