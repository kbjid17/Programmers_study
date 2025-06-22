class Solution {
    public int solution(int[] num_list) {
        int n1 = 0;
        int n2 = 1;
        for(int i = 0; i < num_list.length; i++) {
            n1 += num_list[i];
            n2 *= num_list[i];
        }
        return (int) Math.pow(n1,2) > n2 ? 1 : 0;
    }
}