package 해시.완주하지못한선수_220406;

import java.util.HashMap;

class Solution {
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        
        for (int i = 0; i < participant.length; i++) {
        	if(map.containsKey(participant[i])) {
        		map.put(participant[i], map.get(participant[i])+1);
        	} else {
        		map.put(participant[i], 1);
        	}
			
		}
        for (int i = 0; i < completion.length; i++) {
			if(map.get(completion[i]) > 0) {
				map.put(completion[i], map.get(completion[i])-1);
			}
		}
        for (int i = 0; i < participant.length; i++) {
			if(map.get(participant[i]) > 0) {
				answer = participant[i];
			}
		}
        
        
        return answer;
    }
}