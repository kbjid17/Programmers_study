class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char target_word = '.';
        int target_word_cnt = 0;
        int other_word_cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            System.out.println(target_word + " " + s.charAt(i));
            if(target_word == '.') 
            {
                answer++;
                target_word = s.charAt(i);
                target_word_cnt++;
                System.out.println(target_word + "로 진행");
                continue;
            }
            if(s.charAt(i) == target_word) 
                target_word_cnt++;
            else 
                other_word_cnt++;
            if(target_word_cnt == other_word_cnt) 
            {
                target_word_cnt = 0;
                other_word_cnt = 0;
                target_word = '.';
            }
        }

        
        
        return answer;
    }
}