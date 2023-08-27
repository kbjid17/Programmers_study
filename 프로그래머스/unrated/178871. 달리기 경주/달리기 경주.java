import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i],i);
        }
        for(int i = 0; i < callings.length; i++) {
            String temp = callings[i];
            String a = players[map.get(callings[i])-1];
            
            map.put(players[map.get(temp)], map.get(players[map.get(temp)])-1);
            map.put(players[map.get(a)], map.get(players[map.get(a)])+1);
        
            players[map.get(temp)] = temp;
            players[map.get(a)] = a;
        }
        return players;
    }
}