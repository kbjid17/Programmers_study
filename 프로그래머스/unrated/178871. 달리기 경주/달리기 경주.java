import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i],i);
        }
        for(int i = 0; i < callings.length; i++) {
            // 순서 변경
            String temp = callings[i];
            String a = players[map.get(callings[i])-1];
            
//             System.out.println(temp);
//             System.out.println(a);
            
           
            
//             System.out.println("---------before---------");
            
//             System.out.println(map.get(temp));
//             System.out.println(map.get(a));
            
            
            map.put(players[map.get(temp)], map.get(players[map.get(temp)])-1);
            map.put(players[map.get(a)], map.get(players[map.get(a)])+1);
        
            players[map.get(temp)] = temp;
            players[map.get(a)] = a;
            
            // System.out.println("---------after---------");
            
//             System.out.println(map.get(players[map.get(temp)]));
//             System.out.println(map.get(players[map.get(a)]));
            
//             System.out.println(Arrays.toString(players));
        }
        return players;
    }
}