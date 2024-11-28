import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int totalPeopleCount = people.length;
        int savePeopleCount = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(people);
        
        for(int num : people)
            list.add(num);
        
        while(totalPeopleCount > savePeopleCount){
            if(list.size() < 2){
                answer++;
                break;
            }
            if(list.get(0) + list.get(list.size()-1) > limit){
                list.remove(list.size()-1);
                answer++;
                savePeopleCount++;
                continue;
            }else{// if(list.get(0) + list.get(list.size()-1) = limit){
                list.remove(list.size()-1);
                list.remove(0);
                savePeopleCount += 2;
                answer++;
                continue;
            }
        }
        return answer;
    }
}
