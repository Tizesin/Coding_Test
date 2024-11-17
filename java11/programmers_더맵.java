import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int ez = 0;
        int ez2 = 0;
        int mixScoville = 0;
        
        for(int num : scoville){
            pq.offer(num); 
        }
        ez = pq.poll();
        while(ez < K){
            ez2 = pq.poll();
            mixScoville = ez + (ez2 * 2);
            pq.offer(mixScoville);
            if(pq.size() < 2 && mixScoville < K){
                return -1;
            }
            ez = pq.poll();
            answer++;
        }
        return answer;
    }
}
