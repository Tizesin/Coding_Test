import java.util.*;

class Solution {
   public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>(); 
       
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if (list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
       Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }

}
