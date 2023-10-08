import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)) return 0;
        
        // 현 문자 기준 변경 가능한 문자
        // 한 단어씩 바꿀 수 있음. >> 단어 차이가 1개인 경우로 이동할 수 있음
        // list 기반의 dfs(재귀)를 돌리다가 찾던 단어가 완성되면  깊이 return
        
        dfs(begin, target, words, new boolean[words.length], 0);
        
        return answer;
    }
    
    static void dfs(String begin, String target, String[] words, boolean[] visited,int depth)   {
        
        // 이미 본 word라면 안보도록도 해줘야함
        for(int i = 0; i < words.length; i++) {
            if(check(begin,words[i])) { // begin에서 word[i]로 바꿀 수 있다면
                if(!visited[i]) { // 이전에 방문한 word가 아니라면
                    if(words[i].equals(target)) { // 바꾸고자 하는 문자가 target과 같다면
                        answer = Math.min(answer, ++depth);
                        return;
                    }
                    else {
                        visited[i] = true;
                        dfs(words[i], target, words, visited, depth+1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
    
    static boolean check(String begin, String word) {
        // 단어 하나만 바꿔서 word를 만들 수 있으면 true , 아니면 false
        int diff = 0;
        char[] ch_1 = begin.toCharArray();
        char[] ch_2 = word.toCharArray();
        
        for(int i = 0; i < begin.length(); i++) {
            if(ch_1[i] != ch_2[i]) diff++;
        }
        
        if(diff == 1) return true; // true면 이동 가능
        else return false; // false면 이동 불가능
    }
}