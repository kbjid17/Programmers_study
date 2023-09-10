import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 10000001;
        int[][] ar = new int[n+1][n+1];
        
        for(int i = 0; i < ar.length; i++) {
             for(int j = 0; j < ar[0].length; j++) {
                 if(i == j) continue;
                 ar[i][j] = 10000001;
             }
        }
        
        for(int i = 0; i < fares.length; i++) {
            ar[fares[i][0]][fares[i][1]] = fares[i][2];
            ar[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if(k == i) continue;
                // i > j 비용과 [i > k] + [k + j] 비교
                // ar[i][j] : [i > j] 비용
                // ar[i][k] : ar[k][j] : [i > k] + [k > j] 비용
                for(int j = 1; j <= n; j++) {
                    if(j == k || i == j) continue;
                    ar[i][j] = Math.min(ar[i][j], ar[i][k] + ar[k][j]);
                }
            }
        }
        /* 
        스타트 포인트가 정해짐(s)
        각 정점별로 A와 B로 이동했을 때의 값을 출력
        */
        
        for(int i = 0; i <= n; i++) {
            answer = Math.min(answer, ar[s][i] + ar[i][a] + ar[i][b]);
            // System.out.println(i + " " + answer);
        }
        System.out.println(answer);
        for(int i = 0; i < ar.length; i++) {
            // System.out.println(Arrays.toString(ar[i]));
        }
        return answer;
    }

}