import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int process : priorities){
            que.offer(process);
            pq.offer(process);
        }
        int cycle = 0;
        while(true){
            int queToken = que.poll();
            int pqToken = pq.peek();
            if(queToken == pqToken){
                pq.poll();
                answer++;
                if(cycle == location) break;
            }else{
                que.offer(queToken);
                if(cycle == location) location += que.size();
            }
            cycle++;
        }
        return answer;
    }
}
