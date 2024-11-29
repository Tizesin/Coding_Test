import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int idx = 0; idx < commands.length; idx++){
            int[] subArray = Arrays.copyOfRange(array,
                                                commands[idx][0] - 1,
                                                commands[idx][1]);
            Arrays.sort(subArray);
            answer[idx] = subArray[commands[idx][2]-1];
        }
        return answer;
    }
}
