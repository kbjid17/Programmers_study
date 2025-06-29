class Solution {
    public int solution(String number) {
        int num = 0;
        for(char c : number.toCharArray()) {
            num += ((int)c - 48);
        }
        return num % 9;
    }
}