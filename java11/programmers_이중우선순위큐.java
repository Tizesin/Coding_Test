import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = {0,0};
        int Element = 0;
        for(String str : operations){
            if(str.contains("I")) {
                String[] splitWord = str.split(" ");
                minHeap.add(Integer.valueOf(splitWord[1]));
                maxHeap.add(Integer.valueOf(splitWord[1]));
                Element++;
            }
            else if (str.contains("D 1") && Element != 0) {
                maxHeap.poll();
                Element--;
            }
            else if(str.contains("D -1") && Element != 0){
                minHeap.poll();
                Element--;
            }
            
            if (Element == 0) {
                minHeap.clear();
                maxHeap.clear();
            }
        }
        if(Element != 0){
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        return answer;
    }
}
