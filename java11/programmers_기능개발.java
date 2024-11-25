import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int answerIdx = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int topIdx = 0;
        for(int i = 0; i < progresses.length; i++){
            int needDay = (int) Math.ceil((100-progresses[i]) / (double) speeds[i]);
            que.offer(needDay);
        }
        
        // System.out.println(que);
        int needDay = 0;
        int doneCount = 0;
        while(!que.isEmpty()) {
            int currentNeedDay = que.poll();
            
            if(needDay < currentNeedDay){
                if(needDay != 0)
                    list.add(doneCount);
                needDay = currentNeedDay;
                doneCount = 0;
            }
            doneCount++;
        }
        list.add(doneCount);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
