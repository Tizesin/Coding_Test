import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> pc = new HashMap<>();
        for(String str : participant){
            if(pc.containsKey(str)){
                pc.put(str,pc.get(str)+1);
                continue;
            }
            pc.put(str,1);
        }
        
        for(String str : completion){
            if(pc.containsKey(str)){
                int count = pc.get(str) - 1;
                if(count == 0)
                    pc.remove(str);
                else
                    pc.put(str,count);
            }
        }
        Map.Entry<String, Integer> singleEntry = pc.entrySet().iterator().next();
        return singleEntry.getKey();
    }
}
