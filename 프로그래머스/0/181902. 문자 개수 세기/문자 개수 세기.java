class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] ch = my_string.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            System.out.println(ch[i] + " : " + (ch[i]-'0'));
            if(ch[i] >= 'A' && ch[i] <= 'Z') {
                answer[ch[i]-'A']++;
            }
            else if(ch[i] >= 'a' && ch[i] <= 'z') {
                answer[ch[i]-'0'-23]++;
            }
            
        }
        return answer;
    }
}