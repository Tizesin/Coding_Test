import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for(int idx = 0; idx < arr.length; idx++){
            if(idx == 0 || arr[idx] !=arr[idx-1] )
                list.add(arr[idx]);
        }
        int[] answer = list.stream().mapToInt(e->e).toArray();

        return answer;
    }
}