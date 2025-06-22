class Solution {
    public int solution(int[] num_list) {
        StringBuilder sb_1 = new StringBuilder();
        StringBuilder sb_2 = new StringBuilder();
        
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0) sb_1.append(num_list[i]);
            else sb_2.append(num_list[i]);
        }
        return Integer.parseInt(sb_1.toString()) + Integer.parseInt(sb_2.toString());
    }
}