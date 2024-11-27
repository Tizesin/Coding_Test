import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(destPos -> destPos[1]));
        Integer camPos = null;
        for(int[] route : routes) {
            if(camPos == null || (route[0] > camPos || route[1] < camPos)) {
                camPos = route[1];
                answer++;
            }
        }
        return answer;
    }
}
